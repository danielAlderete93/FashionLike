package com.fashionlike.proyecto_fashion_like.domain.exceptions;

public class InvalidCredentialsException extends DomainException{
    public InvalidCredentialsException() {
    }

    public InvalidCredentialsException(String message) {
        super(message);
    }
}
