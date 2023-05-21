package com.fashionlike.proyecto_fashion_like.app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusResponse {
    private String title;
    private String message;
    private int code;

    public static StatusResponse errorServer(String message) {
        return new StatusResponse("Error", message, 500);
    }

    public static StatusResponse notFound(String message) {
        return new StatusResponse("Error", message, 404);
    }

    public static StatusResponse notCreated(String message) {
        return new StatusResponse("Error", message, 400);
    }

    public static StatusResponse created(String message) {
        return new StatusResponse("Success", message, 201);
    }

    public static StatusResponse found(String message) {
        return new StatusResponse("Success", message, 200);
    }


}
