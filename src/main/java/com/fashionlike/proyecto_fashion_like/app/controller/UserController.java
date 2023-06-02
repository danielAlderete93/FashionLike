package com.fashionlike.proyecto_fashion_like.app.controller;


import com.fashionlike.proyecto_fashion_like.app.api.ApiResponseBuilder;
import com.fashionlike.proyecto_fashion_like.app.dto.UserDTO;
import com.fashionlike.proyecto_fashion_like.domain.usecase.UserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/private/user/")
public class UserController extends BaseController<UserDTO> {
    @Autowired
    public UserController(UserUseCase useCase, ApiResponseBuilder<UserDTO> apiResponseBuilder) {
        super(useCase, apiResponseBuilder);
    }


    @GetMapping("/resource")
    public ResponseEntity<String> getResource() {
        // Lógica del endpoint
        return ResponseEntity.ok("Resource accessed successfully");
    }

}
