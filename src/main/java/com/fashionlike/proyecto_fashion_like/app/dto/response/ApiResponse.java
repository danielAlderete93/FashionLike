package com.fashionlike.proyecto_fashion_like.app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private T data;
    private StatusResponse status;

    public static <T> ApiResponse<T> success(T data, StatusResponse status) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setData(data);
        response.setStatus(status);
        return response;
    }


    public static <T> ApiResponse<T> error(StatusResponse status) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setStatus(status);
        return response;
    }
}