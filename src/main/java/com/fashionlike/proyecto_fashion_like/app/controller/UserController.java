package com.fashionlike.proyecto_fashion_like.app.controller;


import com.fashionlike.proyecto_fashion_like.app.api.ApiResponseBuilder;
import com.fashionlike.proyecto_fashion_like.app.dto.UserDTO;
import com.fashionlike.proyecto_fashion_like.domain.usecase.UserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user/")

public class UserController extends BaseController<UserDTO> {
    @Autowired
    public UserController(UserUseCase useCase, ApiResponseBuilder<UserDTO> apiResponseBuilder) {
        super(useCase, apiResponseBuilder);
    }
}
