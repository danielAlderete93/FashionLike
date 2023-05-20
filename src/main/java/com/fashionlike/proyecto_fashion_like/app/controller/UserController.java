package com.fashionlike.proyecto_fashion_like.app.controller;


import com.fashionlike.proyecto_fashion_like.app.dto.UserDTO;
import com.fashionlike.proyecto_fashion_like.app.mapper.MapperController;
import com.fashionlike.proyecto_fashion_like.domain.model.ActionType;
import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.model.role.Role;
import com.fashionlike.proyecto_fashion_like.domain.model.role.RoleAdmin;
import com.fashionlike.proyecto_fashion_like.domain.usecase.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/user/")
@AllArgsConstructor
public class UserController {

    private final UserUseCase userUseCase;
    private final MapperController<User, UserDTO> mapperController;


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
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        try {
            Integer userId = userUseCase.createUser(userDTO);
            if (userId == null) {
                return ResponseEntity.badRequest().build();
            }

            UserDTO createdUserDTO = userUseCase.getUserById(userId);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(userId)
                    .toUri();

            return ResponseEntity.created(location).body(createdUserDTO);
        } catch (Exception e) {
            // Handle other specific exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
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

    @DeleteMapping(value = "/admin")
    public ResponseEntity<UserDTO> prueba() {
        try {
            List<ActionType> actionTypes = new ArrayList<>();
            actionTypes.add(ActionType.VIEW_POST);

            Role role = RoleAdmin.builder()
                    .id(null)
                    .allowedActions(actionTypes)
                    .build();
            User user = User.builder()
                    .name("pepe")
                    .username("pepe")
                    .password("pepe")
                    .role(role)
                    .isActive(true)
                    .build();


            return ResponseEntity.ok(mapperController.toDTO(user));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
