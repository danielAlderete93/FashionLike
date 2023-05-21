package com.fashionlike.proyecto_fashion_like.app.factories;

import com.fashionlike.proyecto_fashion_like.app.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.net.URI;

public interface ApiResponseBuilder<T> {

    ResponseEntity<ApiResponse<T>> createSuccessResponse(URI uri, T data);

    ResponseEntity<ApiResponse<T>> createErrorResponse();

    ResponseEntity<ApiResponse<T>> errorServer(String message);
}
