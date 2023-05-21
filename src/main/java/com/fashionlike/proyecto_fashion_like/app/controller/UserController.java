package com.fashionlike.proyecto_fashion_like.app.controller;


import com.fashionlike.proyecto_fashion_like.app.dto.UserDTO;
import com.fashionlike.proyecto_fashion_like.app.dto.response.ApiResponse;
import com.fashionlike.proyecto_fashion_like.app.factories.ApiResponseBuilder;
import com.fashionlike.proyecto_fashion_like.domain.usecase.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/user/")
@AllArgsConstructor
public class UserController {

    private final UserUseCase userUseCase;
    private final ApiResponseBuilder<UserDTO> apiResponseBuilder;


    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<UserDTO> getUserByID(@PathVariable Integer id) {
        try {
            UserDTO userDTO = userUseCase.getUserById(id);
            if (userDTO == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(userDTO);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<UserDTO>> getAllUser() {
        try {
            List<UserDTO> userDTO = userUseCase.getAllUsers();
            if (userDTO == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(userDTO);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<UserDTO>> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUserDTO;
        URI location;
        try {
            Integer userId = userUseCase.createUser(userDTO);
            if (userId == null) {
                return apiResponseBuilder.createErrorResponse();
            }

            createdUserDTO = userUseCase.getUserById(userId);

            location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(userId)
                    .toUri();

            return apiResponseBuilder.createSuccessResponse(location, createdUserDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return apiResponseBuilder.errorServer(e.getMessage());
        }
    }

    @PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> createUser(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        try {
            userUseCase.updateUser(id, userDTO);
            return ResponseEntity.ok(userDTO);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Integer id) {
        try {
            UserDTO userDTO = userUseCase.getUserById(id);
            userUseCase.deleteUserById(id);

            return ResponseEntity.ok(userDTO);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
