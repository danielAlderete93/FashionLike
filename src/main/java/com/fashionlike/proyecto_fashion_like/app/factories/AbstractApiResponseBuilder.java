package com.fashionlike.proyecto_fashion_like.app.factories;

import com.fashionlike.proyecto_fashion_like.app.dto.response.ApiResponse;
import com.fashionlike.proyecto_fashion_like.app.dto.response.StatusResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;

public abstract class AbstractApiResponseBuilder<T> implements ApiResponseBuilder<T> {

    protected abstract String getEntityName();

    protected String getCreatedMessage() {
        return getEntityName() + " created";
    }

    protected String getUpdatedMessage() {
        return getEntityName() + " updated";
    }

    protected String getDeletedMessage() {
        return getEntityName() + " deleted";
    }

    protected String getFoundMessage() {
        return getEntityName() + " found";
    }

    protected String getNotFoundMessage() {
        return "No " + getEntityName() + " found";
    }


    protected String getAllMessage() {
        return "All " + getEntityName() + "s";
    }

    protected String getErrorMessage(String message) {
        return "Error: " + message;
    }

    @Override
    public ResponseEntity<ApiResponse<T>> createSuccessResponse(URI uri, T data) {
        ApiResponse<T> apiResponse = ApiResponse.success(data, StatusResponse.created(getCreatedMessage()));
        return ResponseEntity.created(uri).body(apiResponse);
    }

    @Override
    public ResponseEntity<ApiResponse<T>> updateSuccessResponse(T data) {
        ApiResponse<T> apiResponse = ApiResponse.success(data, StatusResponse.updated(getUpdatedMessage()));
        return ResponseEntity.ok(apiResponse);
    }

    @Override
    public ResponseEntity<ApiResponse<T>> createErrorResponse(String message) {
        ApiResponse<T> apiResponse = ApiResponse.error(StatusResponse.notCreated(message));
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @Override
    public ResponseEntity<ApiResponse<T>> errorServerResponse(String message) {
        ApiResponse<T> apiResponse = ApiResponse.error(StatusResponse.errorServer(getErrorMessage(message)));
        return ResponseEntity.internalServerError().body(apiResponse);
    }

    @Override
    public ResponseEntity<ApiResponse<T>> deleteSuccessResponse(T data) {
        ApiResponse<T> apiResponse = ApiResponse.success(data, StatusResponse.deleted(getDeletedMessage()));
        return ResponseEntity.ok(apiResponse);
    }

    @Override
    public ResponseEntity<ApiResponse<T>> foundSuccessResponse(T data) {
        ApiResponse<T> apiResponse = ApiResponse.success(data, StatusResponse.found(getFoundMessage()));
        return ResponseEntity.ok(apiResponse);
    }

    @Override
    public ResponseEntity<ApiResponse<T>> notFoundSuccessResponse() {
        ApiResponse<T> apiResponse = ApiResponse.error(StatusResponse.notFound(getNotFoundMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }

    @Override
    public ResponseEntity<ApiResponse<List<T>>> foundListSuccessResponse(List<T> data) {
        ApiResponse<List<T>> apiResponse = ApiResponse.success(data, StatusResponse.found(getAllMessage()));
        return ResponseEntity.ok(apiResponse);
    }

    @Override
    public ResponseEntity<ApiResponse<List<T>>> notFoundListSuccessResponse() {
        ApiResponse<List<T>> apiResponse = ApiResponse.error(StatusResponse.notFound(getNotFoundMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }

    @Override
    public ResponseEntity<ApiResponse<List<T>>> errorServerListResponse(String message) {
        ApiResponse<List<T>> apiResponse = ApiResponse.error(StatusResponse.errorServer(getErrorMessage(message)));
        return ResponseEntity.internalServerError().body(apiResponse);
    }
}