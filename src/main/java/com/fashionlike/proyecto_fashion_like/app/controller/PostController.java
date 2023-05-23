package com.fashionlike.proyecto_fashion_like.app.controller;

import com.fashionlike.proyecto_fashion_like.app.dto.UserDTO;
import com.fashionlike.proyecto_fashion_like.app.dto.response.ApiResponse;
import com.fashionlike.proyecto_fashion_like.app.factories.ApiResponseBuilder;
import com.fashionlike.proyecto_fashion_like.domain.usecase.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/post/")
@AllArgsConstructor
public class PostController {
    private final UserUseCase userUseCase;
    private final ApiResponseBuilder<UserDTO> apiResponseBuilder;


    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<ApiResponse<UserDTO>> getUserByID(@PathVariable Integer id) {
        try {
            UserDTO userDTO = userUseCase.getUserById(id);
            if (userDTO == null) {
                return apiResponseBuilder.notFoundSuccessResponse();
            }
            return apiResponseBuilder.foundSuccessResponse(userDTO);

        } catch (Exception e) {
            e.printStackTrace();
            return apiResponseBuilder.errorServerResponse(e.getMessage());
        }
    }

}
