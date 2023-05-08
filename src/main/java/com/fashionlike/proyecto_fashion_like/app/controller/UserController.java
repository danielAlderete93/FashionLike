package com.fashionlike.proyecto_fashion_like.app.controller;


import com.fashionlike.proyecto_fashion_like.app.dto.UserDTO;
import com.fashionlike.proyecto_fashion_like.app.mapper.MapperController;
import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.port.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
