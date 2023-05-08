package com.fashionlike.proyecto_fashion_like.app.controller;


import com.fashionlike.proyecto_fashion_like.app.dto.UserDTO;
import com.fashionlike.proyecto_fashion_like.app.mapper.MapperController;
import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.port.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;
    private final MapperController<UserDTO, User> mapperController;

    @Autowired
    public UserController(UserService userService, MapperController<UserDTO, User> mapperController) {
        this.userService = userService;
        this.mapperController = mapperController;
    }

    @GetMapping(value = "/{idUser}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        UserDTO userDto = mapperController.toDTO(user);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping(value = "/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        User user = mapperController.toDomain(userDTO);
        userService.createUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }


}
