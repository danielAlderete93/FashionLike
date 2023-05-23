package com.fashionlike.proyecto_fashion_like.app.controller;


import com.fashionlike.proyecto_fashion_like.app.dto.UserDTO;
import com.fashionlike.proyecto_fashion_like.app.dto.response.ApiResponse;
import com.fashionlike.proyecto_fashion_like.app.factories.ApiResponseBuilder;
import com.fashionlike.proyecto_fashion_like.domain.exceptions.DomainException;
import com.fashionlike.proyecto_fashion_like.domain.usecase.UserUseCase;
import lombok.AllArgsConstructor;
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

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<ApiResponse<List<UserDTO>>> getAllUser() {
        try {
            List<UserDTO> userDTO = userUseCase.getAllUsers();
            if (userDTO.isEmpty()) {
                return apiResponseBuilder.notFoundListSuccessResponse();
            }
            return apiResponseBuilder.foundListSuccessResponse(userDTO);

        } catch (Exception e) {
            e.printStackTrace();
            return apiResponseBuilder.errorServerListResponse(e.getMessage());
        }
    }


    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<UserDTO>> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUserDTO;
        URI location;
        try {
            Integer userId = userUseCase.createUser(userDTO);
            createdUserDTO = userUseCase.getUserById(userId);

            location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(userId)
                    .toUri();

            return apiResponseBuilder.createSuccessResponse(location, createdUserDTO);
        } catch (DomainException e) {
            return apiResponseBuilder.createErrorResponse(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return apiResponseBuilder.errorServerResponse(e.getMessage());
        }
    }

    @PutMapping(value = "/edit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<UserDTO>> updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        UserDTO userUpdated;
        try {

            userUseCase.updateUser(id, userDTO);
            userUpdated = userUseCase.getUserById(id);
            return apiResponseBuilder.updateSuccessResponse(userUpdated);

        } catch (Exception e) {
            e.printStackTrace();
            return apiResponseBuilder.errorServerResponse(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> deleteUser(@PathVariable Integer id) {
        try {
            UserDTO userDTO = userUseCase.getUserById(id);
            userUseCase.deleteUserById(id);

            return apiResponseBuilder.deleteSuccessResponse(userDTO);

        } catch (Exception e) {
            e.printStackTrace();
            return apiResponseBuilder.errorServerResponse(e.getMessage());
        }
    }


}
