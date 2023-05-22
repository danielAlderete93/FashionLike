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
        return new StatusResponse("Error: Internal Server", message, 500);
    }

    public static StatusResponse notFound(String message) {
        return new StatusResponse("Error: Not found", message, 404);
    }

    public static StatusResponse notCreated(String message) {
        return new StatusResponse("Error: Not created", message, 400);
    }

    public static StatusResponse created(String message) {
        return new StatusResponse("Success: Created", message, 201);
    }

    public static StatusResponse updated(String message) {
        return new StatusResponse("Success: Updated", message, 200);
    }

    public static StatusResponse deleted(String message) {
        return new StatusResponse("Success: Delete", message, 200);
    }

    public static StatusResponse found(String message) {
        return new StatusResponse("Success", message, 200);
    }


}
