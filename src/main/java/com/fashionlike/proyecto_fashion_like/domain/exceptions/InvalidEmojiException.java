package com.fashionlike.proyecto_fashion_like.domain.exceptions;

public class InvalidEmojiException extends DomainException {
    public InvalidEmojiException() {
    }

    public InvalidEmojiException(String message) {
        super("The emoji '" + message + "' already exists.");
    }
}
