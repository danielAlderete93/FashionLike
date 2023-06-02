package com.fashionlike.proyecto_fashion_like.app.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncryptionUtil {


    private final PasswordEncoder encoder;

    @Autowired
    public PasswordEncryptionUtil(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public String encrypt(String password) {
        return encoder.encode(password);
    }

    public boolean matches(String rawPassword, String encryptedPassword) {
        return encoder.matches(rawPassword, encryptedPassword);
    }
}
