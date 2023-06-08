package com.fashionlike.proyecto_fashion_like.app.usecase.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusResponse {
    private String title;
    private String message;
    private int code;

    public static StatusResponse errorServer(String message) {
        return createStatusResponse(StatusResponseTitle.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    public static StatusResponse notFound(String message) {
        return createStatusResponse(StatusResponseTitle.NOT_FOUND, HttpStatus.NOT_FOUND, message);

    }

    public static StatusResponse notCreated(String message) {
        return createStatusResponse(StatusResponseTitle.NOT_CREATED, HttpStatus.BAD_REQUEST, message);
    }

    public static StatusResponse created(String message) {
        return createStatusResponse(StatusResponseTitle.CREATED, HttpStatus.CREATED, message);
    }

    public static StatusResponse updated(String message) {
        return createStatusResponse(StatusResponseTitle.UPDATED, HttpStatus.OK, message);
    }

    public static StatusResponse notUpdated(String message) {
        return createStatusResponse(StatusResponseTitle.NOT_UPDATED, HttpStatus.BAD_REQUEST, message);
    }

    public static StatusResponse deleted(String message) {
        return createStatusResponse(StatusResponseTitle.DELETED, HttpStatus.OK, message);
    }

    public static StatusResponse found(String message) {
        return createStatusResponse(StatusResponseTitle.FOUND, HttpStatus.FOUND, message);
    }

    public static StatusResponse errorUnauthorized(String message) {
        return createStatusResponse(StatusResponseTitle.UNAUTHORIZED, HttpStatus.UNAUTHORIZED, message);
    }


    private static StatusResponse createStatusResponse(StatusResponseTitle title, HttpStatus httpStatus, String message) {
        String titleMessage = title.getMessage();
        int code = httpStatus.value();

        return new StatusResponse(titleMessage, message, code);
    }
}
