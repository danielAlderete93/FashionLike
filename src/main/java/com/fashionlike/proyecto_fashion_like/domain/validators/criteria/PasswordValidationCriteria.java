package com.fashionlike.proyecto_fashion_like.domain.validators.criteria;

import com.fashionlike.proyecto_fashion_like.domain.exceptions.InvalidPasswordException;
import com.fashionlike.proyecto_fashion_like.domain.exceptions.DomainException;
import com.fashionlike.proyecto_fashion_like.domain.model.User;

public class PasswordValidationCriteria implements DomainValidationCriteria<User> {
    private static final int MIN_LENGTH = 8;
    private static final String ERROR_MIN_LENGTH = "The password must have at least %d characters";
    private static final String ERROR_LOWERCASE_LETTER = "The password must contain at least one lowercase letter";
    private static final String ERROR_UPPERCASE_LETTER = "The password must contain at least one uppercase letter";
    private static final String ERROR_NUMBER = "The password must contain at least one number";

    @Override
    public void validate(User user) throws DomainException {
        String password = user.getPassword();

        validateMinimumLength(password);
        validateLowercaseLetter(password);
        validateUppercaseLetter(password);
        validateNumber(password);
    }

    private void validateMinimumLength(String password) {
        if (password.length() < MIN_LENGTH) {
            throw new InvalidPasswordException(String.format(ERROR_MIN_LENGTH, MIN_LENGTH));
        }
    }

    private void validateLowercaseLetter(String password) {
        if (!password.matches(".*[a-z].*")) {
            throw new InvalidPasswordException(ERROR_LOWERCASE_LETTER);
        }
    }

    private void validateUppercaseLetter(String password) {
        if (!password.matches(".*[A-Z].*")) {
            throw new InvalidPasswordException(ERROR_UPPERCASE_LETTER);
        }
    }

    private void validateNumber(String password) {
        if (!password.matches(".*\\d.*")) {
            throw new InvalidPasswordException(ERROR_NUMBER);
        }
    }
}

