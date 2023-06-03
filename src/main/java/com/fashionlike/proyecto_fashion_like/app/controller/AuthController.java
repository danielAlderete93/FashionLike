package com.fashionlike.proyecto_fashion_like.app.controller;

import com.fashionlike.proyecto_fashion_like.app.api.ApiResponseBuilder;
import com.fashionlike.proyecto_fashion_like.app.dto.LoginRequest;
import com.fashionlike.proyecto_fashion_like.app.dto.RegisterRequest;
import com.fashionlike.proyecto_fashion_like.app.dto.TokenResponse;
import com.fashionlike.proyecto_fashion_like.app.dto.UserDTO;
import com.fashionlike.proyecto_fashion_like.app.dto.response.ApiResponse;
import com.fashionlike.proyecto_fashion_like.app.dto.response.StatusResponse;
import com.fashionlike.proyecto_fashion_like.domain.exceptions.DomainException;
import com.fashionlike.proyecto_fashion_like.domain.usecase.AuthUseCase;
import com.fashionlike.proyecto_fashion_like.domain.usecase.MailSenderUseCase;
import com.fashionlike.proyecto_fashion_like.domain.usecase.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/public/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthUseCase authUseCase;
    private final UserUseCase useCase;

    private final MailSenderUseCase mailSenderUseCase;

    ApiResponseBuilder<UserDTO> apiResponseBuilder;


    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ApiResponse<TokenResponse>> login(@RequestBody LoginRequest loginRequest) {
        // Lógica para autenticar al usuario y generar el token JWT
        try {
            String token = authUseCase.login(loginRequest);

            TokenResponse tokenResponse = TokenResponse.builder().token(token).build();
            ApiResponse<TokenResponse> response = new ApiResponse<>(tokenResponse, StatusResponse.found("authentication"));

            return ResponseEntity.ok(response);
        } catch (DomainException e) {
            ApiResponse<TokenResponse> response = new ApiResponse<>(null, StatusResponse.errorUnauthorized(e.getMessage()));
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        } catch (Exception e) {
            e.printStackTrace();
            ApiResponse<TokenResponse> response = new ApiResponse<>(null, StatusResponse.errorServer(e.getMessage()));
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    public ResponseEntity<ApiResponse<UserDTO>> register(@RequestBody RegisterRequest registerRequest) {
        // Lógica para autenticar al usuario y generar el token JWT
        UserDTO createdDTO;
        URI location;
        try {
            Integer id = authUseCase.register(registerRequest);
            createdDTO = useCase.getById(id);

            location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(id)
                    .toUri();

            mailSenderUseCase.sendValidationRegister(createdDTO);

            return apiResponseBuilder.createSuccessResponse(location, createdDTO);
        } catch (DomainException e) {
            return apiResponseBuilder.createErrorResponse(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return apiResponseBuilder.errorServerResponse(e.getMessage());
        }
    }

}
