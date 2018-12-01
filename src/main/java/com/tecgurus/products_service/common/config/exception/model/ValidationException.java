package com.tecgurus.products_service.common.config.exception.model;

import com.tecgurus.products_service.common.util.EventMessage;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public class ValidationException extends Exception {

    private Object body;
    private EventMessage eventMessage;

    public ValidationException(EventMessage eventMessage, Object... args) {
        super(String.format(eventMessage.getMessage(), args));
        this.eventMessage = eventMessage;
    }

    public ValidationException(EventMessage eventMessage) {
        super(eventMessage.getMessage());
        this.eventMessage = eventMessage;
    }

    public ValidationException(String message, Object body) {
        super(message);
        setBody(body);
    }

}

