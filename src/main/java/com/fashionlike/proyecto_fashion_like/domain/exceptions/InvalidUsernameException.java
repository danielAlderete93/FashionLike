package com.fashionlike.proyecto_fashion_like.domain.exceptions;

public class InvalidUsernameException extends DomainException {
    public InvalidUsernameException() {
    }

    public InvalidUsernameException(String username) {
        super("The username '" + username + "' already exists.");
    }
}