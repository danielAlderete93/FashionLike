package com.fashionlike.proyecto_fashion_like.domain.usecase;

import com.fashionlike.proyecto_fashion_like.app.dto.UserDTO;

import java.util.List;

public interface UserUseCase {
    UserDTO getUserById(Integer id);

    List<UserDTO> getAllUsers();

    Integer createUser(UserDTO user);

    void updateUser(Integer id, UserDTO user);

    void deleteUserById(Integer id);
}