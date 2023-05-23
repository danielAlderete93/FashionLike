package com.fashionlike.proyecto_fashion_like.domain.exceptions;

public class TagNotFoundException extends DomainException {
    public TagNotFoundException() {
    }

    public TagNotFoundException(String message) {
        super("The tag " + message + "was not found.");
    }
}
