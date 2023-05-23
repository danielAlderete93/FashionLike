package com.fashionlike.proyecto_fashion_like.domain.exceptions;

public class InvalidTitleException extends DomainException {
    public InvalidTitleException() {
    }

    public InvalidTitleException(String message) {
        super("The post with title '" + message + "' already exists.");
    }
}
