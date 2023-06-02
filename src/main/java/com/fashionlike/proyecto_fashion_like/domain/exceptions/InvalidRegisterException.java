package com.fashionlike.proyecto_fashion_like.domain.exceptions;

public class InvalidRegisterException extends DomainException{
    public InvalidRegisterException() {
    }

    public InvalidRegisterException(String message) {
        super(message);
    }
}
