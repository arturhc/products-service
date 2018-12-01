package com.tecgurus.products_service.app.dto.product;

import lombok.Data;

@Data
public class ProductDTO {

    private Long id;
    private String name;
    private double latitude;
    private double longitude;

}
