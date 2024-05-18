package cz.itnetwork.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity(name = "invoice")
@Getter
@Setter
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
