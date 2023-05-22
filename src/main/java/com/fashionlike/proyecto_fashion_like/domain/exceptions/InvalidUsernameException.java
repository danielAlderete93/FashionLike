package com.fashionlike.proyecto_fashion_like.domain.exceptions;

public class InvalidUsernameException extends UserDomainException {
    public InvalidUsernameException() {
    }

    public InvalidUsernameException(String username) {
        super("The username '" + username + "' already exists.");
    }
}
