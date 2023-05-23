package com.fashionlike.proyecto_fashion_like.domain.exceptions;

public class InvalidPasswordException extends DomainException {
    public InvalidPasswordException() {
    }

    public InvalidPasswordException(String message) {
        super(message);
    }
}