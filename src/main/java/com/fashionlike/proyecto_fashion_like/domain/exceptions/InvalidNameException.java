package com.fashionlike.proyecto_fashion_like.domain.exceptions;

public class InvalidNameException extends DomainException {
    public InvalidNameException() {
    }

    public InvalidNameException(String message) {
        super("The name '" + message + "' already exists.");
    }
}
