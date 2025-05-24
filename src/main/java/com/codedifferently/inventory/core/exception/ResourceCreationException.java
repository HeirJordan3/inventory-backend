package com.codedifferently.inventory.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceCreationException extends RuntimeException {
    public ResourceCreationException(String message) {
        super(message);
    }
}