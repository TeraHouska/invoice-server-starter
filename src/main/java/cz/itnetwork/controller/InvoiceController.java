package cz.itnetwork.controller;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.InvoiceStatsDTO;
import cz.itnetwork.entity.filter.InvoiceFilter;
import cz.itnetwork.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;

    @PostMapping
    public InvoiceDTO addInvoice(@RequestBody InvoiceDTO invoiceDTO) {
        return invoiceService.addInvoice(invoiceDTO);
    }

    @GetMapping
    public List<InvoiceDTO> getInvoices(InvoiceFilter filter) {
        return invoiceService.getAll(filter);
    }

    @GetMapping("/{invoiceId}")
    public InvoiceDTO getInvoiceDetail(@PathVariable long invoiceId) {
        return invoiceService.findInvoiceById(invoiceId);
    }

    @DeleteMapping("/{invoiceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeInvoice(@PathVariable Long invoiceId) {
        invoiceService.removeInvoice(invoiceId);
    }

    @PutMapping("/{invoiceId}")
    public InvoiceDTO editInvoice(@PathVariable long invoiceId, @RequestBody InvoiceDTO invoiceDTO) {
        return invoiceService.editInvoice(invoiceId, invoiceDTO);
    }

    @GetMapping("/statistics")
    public InvoiceStatsDTO getInvoiceStats() {
        return invoiceService.getStats();
    }
}
