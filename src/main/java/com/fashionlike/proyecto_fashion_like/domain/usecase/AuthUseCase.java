package com.fashionlike.proyecto_fashion_like.domain.usecase;

import com.fashionlike.proyecto_fashion_like.app.dto.LoginRequest;
import com.fashionlike.proyecto_fashion_like.app.dto.RegisterRequest;
import com.fashionlike.proyecto_fashion_like.domain.exceptions.InvalidCredentialsException;

public interface AuthUseCase {
    String login(LoginRequest loginRequest);

    Integer register(RegisterRequest registerRequest);

    boolean activeUser(String token);


    void verifyCredentials(String username, String password) throws InvalidCredentialsException;

    String generateRegisterTokenForUserByID(Integer id);
}
