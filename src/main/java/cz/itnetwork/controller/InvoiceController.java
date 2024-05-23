package cz.itnetwork.controller;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;

    @PostMapping("/invoices")
    public InvoiceDTO addInvoice(@RequestBody InvoiceDTO invoiceDTO) {
        return invoiceService.addInvoice(invoiceDTO);
    }

    @GetMapping("/invoices")
    public List<InvoiceDTO> getInvoices() {
        return invoiceService.getAll();
    }

    @GetMapping("/invoices/{invoiceId}")
    public InvoiceDTO getInvoiceDetail(@PathVariable long invoiceId) {
        return invoiceService.findInvoiceById(invoiceId);
    }

    @DeleteMapping("/invoices/{invoiceId}")
    public void removeInvoice(@PathVariable Long invoiceId) {
        invoiceService.removeInvoice(invoiceId);
    }

    @PutMapping("/invoices/{invoiceId}")
    public InvoiceDTO editInvoice(@PathVariable long invoiceId, @RequestBody InvoiceDTO invoiceDTO) {
        return invoiceService.editInvoice(invoiceId, invoiceDTO);
    }
}
