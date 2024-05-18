package cz.itnetwork.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDTO {

    private Long id;

    private int invoiceNumber;

    private Date issued;

    private Date dueDate;

    private String product;

    private Long price;

    private int vat;

    private String note;

    //private Person buyer;

    //private Person seller;
}
