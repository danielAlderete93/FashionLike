package com.fashionlike.proyecto_fashion_like.domain.exceptions;

public class DomainException extends RuntimeException{
    public DomainException() {
    }

    public DomainException(String message) {
        super(message);
    }
}
