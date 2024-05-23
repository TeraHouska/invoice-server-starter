package cz.itnetwork.service;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.mapper.InvoiceMapper;
import cz.itnetwork.dto.mapper.PersonMapper;
import cz.itnetwork.entity.InvoiceEntity;
import cz.itnetwork.entity.repository.InvoiceRepository;
import cz.itnetwork.entity.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoiceMapper invoiceMapper;
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    PersonMapper personMapper;
    @Autowired
    PersonRepository personRepository;

    @Override
    public InvoiceDTO addInvoice(InvoiceDTO invoiceDTO) {
        InvoiceEntity entity = invoiceMapper.toEntity(invoiceDTO);
        entity = invoiceRepository.save(entity);
        InvoiceDTO resultDTO = invoiceMapper.toDTO(entity);

        long buyerId = entity.getBuyer().getId();
        long sellerId = entity.getSeller().getId();
        resultDTO.setBuyer(personMapper.toDTO(personRepository.getReferenceById(buyerId)));
        resultDTO.setSeller(personMapper.toDTO(personRepository.getReferenceById(sellerId)));
        return resultDTO;
    }

    @Override
    public List<InvoiceDTO> getAll() {
        return invoiceRepository.findAll()
                .stream()
                .map(invoiceEntity -> invoiceMapper.toDTO(invoiceEntity))
                .toList();
    }

    @Override
    public InvoiceDTO findInvoiceById(long invoiceId) {
        return invoiceMapper.toDTO(fetchInvoiceOrThrow(invoiceId));
    }

    @Override
    public void removeInvoice(long invoiceId) {
        InvoiceEntity fetchedInvoice = fetchInvoiceOrThrow(invoiceId);
        invoiceRepository.delete(fetchedInvoice);
    }

    @Override
    public InvoiceDTO editInvoice(long invoiceId, InvoiceDTO invoiceDTO) {
        InvoiceEntity fetchedInvoice = fetchInvoiceOrThrow(invoiceId);
        invoiceDTO.setId(invoiceId);
        invoiceMapper.updateInvoiceEntity(invoiceDTO, fetchedInvoice);
        InvoiceEntity resultEntity = invoiceRepository.save(fetchedInvoice);
        InvoiceDTO resultDTO = invoiceMapper.toDTO(resultEntity);
        resultDTO.setBuyer(personMapper.toDTO(personRepository.getReferenceById(resultDTO.getBuyer().getId())));
        resultDTO.setSeller(personMapper.toDTO(personRepository.getReferenceById(resultDTO.getSeller().getId())));
        return resultDTO;
    }

    //region: private methods
    private InvoiceEntity fetchInvoiceOrThrow(long invoiceId) {
        return invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new NotFoundException("Invoice with id " + invoiceId + " wasn't found in the database."));
    }
    //endregion
}
