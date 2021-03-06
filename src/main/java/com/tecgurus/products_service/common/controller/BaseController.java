package com.tecgurus.products_service.common.controller;

import com.tecgurus.useraccounts.common.config.exception.model.ValidationException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.context.support.DefaultMessageSourceResolvable;

import java.util.List;
import java.util.stream.Collectors;

public class BaseController {

    protected void throwErrors(BindingResult bindingResult) throws ValidationException {

        if (bindingResult.hasErrors()) {

            List<String> errors = bindingResult.getAllErrors()
                    .stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());

            throw new ValidationException("Validation errors", errors);
        }

    }

    protected UserDetails currentUser(Authentication authentication) {
        return (UserDetails) authentication.getPrincipal();
    }

}
