package com.fashionlike.proyecto_fashion_like.domain.exceptions;

public class UserDomainException extends RuntimeException{
    public UserDomainException() {
    }

    public UserDomainException(String message) {
        super(message);
    }
}
