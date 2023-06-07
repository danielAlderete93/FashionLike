package com.fashionlike.proyecto_fashion_like.app.api.builder.crud;

import com.fashionlike.proyecto_fashion_like.app.usecase.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;

public interface ApiCRUDResponseBuilder<T> {

    ResponseEntity<ApiResponse<T>> createSuccessResponse(URI uri, T data);

    ResponseEntity<ApiResponse<T>> updateSuccessResponse(T data);

    ResponseEntity<ApiResponse<T>> updateErrorResponse(String message);

    ResponseEntity<ApiResponse<T>> deleteSuccessResponse(T data);

    ResponseEntity<ApiResponse<T>> foundSuccessResponse(T data);

    ResponseEntity<ApiResponse<T>> createErrorResponse(String message);

    ResponseEntity<ApiResponse<T>> errorServerResponse(String message);

    ResponseEntity<ApiResponse<T>> notFoundSuccessResponse();


    ResponseEntity<ApiResponse<List<T>>> foundListSuccessResponse(List<T> data);

    ResponseEntity<ApiResponse<List<T>>> notFoundListSuccessResponse();

    ResponseEntity<ApiResponse<List<T>>> errorServerListResponse(String message);
}
