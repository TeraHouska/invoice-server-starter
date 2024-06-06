package cz.itnetwork.entity.filter;

import lombok.Data;

@Data
public class InvoiceFilter {
    private Long buyerID;
    private Long sellerID;
    private String product;
    private Integer minPrice;
    private Integer maxPrice;
    private int limit = 20;
}
