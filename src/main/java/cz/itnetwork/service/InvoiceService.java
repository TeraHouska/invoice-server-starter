package cz.itnetwork.service;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.InvoiceStatsDTO;

import java.util.List;

public interface InvoiceService {
    InvoiceDTO addInvoice(InvoiceDTO invoiceDTO);

    List<InvoiceDTO> getAll();

    InvoiceDTO findInvoiceById(long invoiceId);

    void removeInvoice(long invoiceId);

    InvoiceDTO editInvoice(long invoiceId, InvoiceDTO invoiceDTO);

    InvoiceStatsDTO getStats();
}
