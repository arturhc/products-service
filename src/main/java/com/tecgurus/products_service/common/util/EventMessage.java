package com.tecgurus.products_service.common.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EventMessage {

    INVALID_PRODUCT(11, "The product with id %d does not exist."),
    NON_EXISTENT_PRODUCT(16, "The product with name %s does not exist.");

    private Integer code;
    private String message;

}
