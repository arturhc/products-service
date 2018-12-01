package com.tecgurus.products_service.app.dto.product.create;

import com.tecgurus.products_service.app.dto.product.ProductDTO;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductCreateDTO extends ProductDTO {

    public ProductCreateDTO(String name, double latitude, double longitude) {
        setName(name);
        setLatitude(latitude);
        setLongitude(longitude);
    }

}
