package com.fashionlike.proyecto_fashion_like.app.controller.auth;

import com.fashionlike.proyecto_fashion_like.app.usecase.auth.dto.LoginRequestDTO;
import com.fashionlike.proyecto_fashion_like.app.usecase.auth.dto.LoginResponseDTO;
import com.fashionlike.proyecto_fashion_like.app.usecase.auth.dto.RegisterRequestDTO;
import com.fashionlike.proyecto_fashion_like.app.usecase.dto.response.ApiResponse;
import com.fashionlike.proyecto_fashion_like.app.usecase.dto.response.StatusResponse;
import com.fashionlike.proyecto_fashion_like.app.usecase.user.dto.UserDTO;
import com.fashionlike.proyecto_fashion_like.domain.exceptions.DomainException;
import com.fashionlike.proyecto_fashion_like.domain.usecase.AuthUseCase;
import com.fashionlike.proyecto_fashion_like.domain.usecase.CRUDUseCase;
import com.fashionlike.proyecto_fashion_like.domain.usecase.MailSenderUseCase;
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
    private final CRUDUseCase<UserDTO> useCase;

    private final MailSenderUseCase mailSenderUseCase;


    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ApiResponse<LoginResponseDTO>> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        // Lógica para autenticar al usuario y generar el token JWT
        try {
            String token = authUseCase.login(loginRequestDTO);

            LoginResponseDTO loginResponseDTO = LoginResponseDTO.builder().token(token).build();
            ApiResponse<LoginResponseDTO> response = new ApiResponse<>(loginResponseDTO, StatusResponse.found("authentication"));

            return ResponseEntity.ok(response);
        } catch (DomainException e) {
            ApiResponse<LoginResponseDTO> response = new ApiResponse<>(null, StatusResponse.errorUnauthorized(e.getMessage()));
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    public ResponseEntity<ApiResponse<UserDTO>> register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        // Lógica para autenticar al usuario y generar el token JWT
        UserDTO createdDTO;
        URI location;
        ApiResponse<UserDTO> apiResponse;

        try {
            Integer id = authUseCase.register(registerRequestDTO);
            createdDTO = useCase.getById(id);

            location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(id)
                    .toUri();
            String token = authUseCase.generateRegisterTokenForUserByID(id);
            mailSenderUseCase.sendValidationRegister(createdDTO, token);

            apiResponse = ApiResponse.success(createdDTO, StatusResponse.created("Success created"));
            return ResponseEntity.created(location).body(apiResponse);
        } catch (DomainException e) {
            apiResponse = ApiResponse.error(StatusResponse.notCreated(e.getMessage()));
            return ResponseEntity.badRequest().body(apiResponse);
        }
    }

    @GetMapping(value = "/validate")
    @ResponseBody
    public ResponseEntity<ApiResponse<String>> activeUser(@RequestParam String token) {
        // Lógica para autenticar al usuario y generar el token JWT
        ApiResponse<String> apiResponse;
        ResponseEntity<ApiResponse<String>> response;
        try {
            if (authUseCase.activeUser(token)) {
                apiResponse = ApiResponse.success("User is active", StatusResponse.found("Active"));
                response = ResponseEntity.ok(apiResponse);
            } else {
                apiResponse = ApiResponse.error(StatusResponse.notFound("No active"));
                response = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiResponse);
            }

            return response;
        } catch (DomainException e) {
            apiResponse = ApiResponse.error(StatusResponse.errorUnauthorized(e.getMessage()));
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiResponse);
        }
    }

}
