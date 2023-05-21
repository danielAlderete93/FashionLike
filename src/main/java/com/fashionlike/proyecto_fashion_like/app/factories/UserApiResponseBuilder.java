package com.fashionlike.proyecto_fashion_like.app.factories;

import com.fashionlike.proyecto_fashion_like.app.dto.UserDTO;
import com.fashionlike.proyecto_fashion_like.app.dto.response.ApiResponse;
import com.fashionlike.proyecto_fashion_like.app.dto.response.StatusResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class UserApiResponseBuilder implements ApiResponseBuilder<UserDTO> {

    @Override
    public ResponseEntity<ApiResponse<UserDTO>> createSuccessResponse(URI uri, UserDTO data) {
        ResponseEntity<ApiResponse<UserDTO>> response;
        String message;
        ApiResponse<UserDTO> apiResponse;

        message = "User created";
        apiResponse = ApiResponse.success(data, StatusResponse.created(message));
        response = ResponseEntity.created(uri).body(apiResponse);

        return response;
    }

    @Override
    public ResponseEntity<ApiResponse<UserDTO>> createErrorResponse() {
        ResponseEntity<ApiResponse<UserDTO>> response;
        String message;
        ApiResponse<UserDTO> apiResponse;

        message = "User not created";
        apiResponse = ApiResponse.error(StatusResponse.notCreated(message));
        response = ResponseEntity.badRequest().body(apiResponse);

        return response;
    }

    @Override
    public ResponseEntity<ApiResponse<UserDTO>> errorServer(String message) {
        ResponseEntity<ApiResponse<UserDTO>> response;
        ApiResponse<UserDTO> apiResponse;

        apiResponse = ApiResponse.error(StatusResponse.errorServer(message));
        response = ResponseEntity.internalServerError().body(apiResponse);

        return response;
    }
}
