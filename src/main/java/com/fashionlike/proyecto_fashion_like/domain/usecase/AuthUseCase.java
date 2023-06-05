package com.fashionlike.proyecto_fashion_like.domain.usecase;

import com.fashionlike.proyecto_fashion_like.app.usecase.auth.dto.LoginRequestDTO;
import com.fashionlike.proyecto_fashion_like.app.usecase.auth.dto.RegisterRequestDTO;
import com.fashionlike.proyecto_fashion_like.domain.exceptions.InvalidCredentialsException;

public interface AuthUseCase {
    String login(LoginRequestDTO loginRequestDTO);

    Integer register(RegisterRequestDTO registerRequestDTO);

    boolean activeUser(String token);


    void verifyCredentials(String username, String password) throws InvalidCredentialsException;

    String generateRegisterTokenForUserByID(Integer id);
}
