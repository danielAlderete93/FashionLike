package com.fashionlike.proyecto_fashion_like.app.controller;

import com.fashionlike.proyecto_fashion_like.app.dto.LoginRequest;
import com.fashionlike.proyecto_fashion_like.app.dto.TokenResponse;
import com.fashionlike.proyecto_fashion_like.app.dto.response.ApiResponse;
import com.fashionlike.proyecto_fashion_like.app.dto.response.StatusResponse;
import com.fashionlike.proyecto_fashion_like.domain.exceptions.DomainException;
import com.fashionlike.proyecto_fashion_like.domain.usecase.AuthUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/public/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthUseCase authUseCase;


    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ApiResponse<TokenResponse>> login(@RequestBody LoginRequest loginRequest) {
        // Lógica para autenticar al usuario y generar el token JWT
        try {
            String token = authUseCase.login(loginRequest.getUsername(), loginRequest.getPassword());

            TokenResponse tokenResponse = TokenResponse.builder().token(token).build();
            ApiResponse<TokenResponse> response = new ApiResponse<>(tokenResponse, StatusResponse.found("authentication"));

            return ResponseEntity.ok(response);
        } catch (DomainException e) {
            ApiResponse<TokenResponse> response = new ApiResponse<>(null, StatusResponse.errorUnauthorized(e.getMessage()));
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        } catch (Exception e) {
            ApiResponse<TokenResponse> response = new ApiResponse<>(null, StatusResponse.errorServer(e.getMessage()));
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

}
