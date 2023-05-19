package com.fashionlike.proyecto_fashion_like.domain.usecase;

import com.fashionlike.proyecto_fashion_like.app.dto.UserDTO;
import com.fashionlike.proyecto_fashion_like.domain.model.role.Role;

import java.util.List;

public interface UserUseCase {
    UserDTO getUserById(Integer id);

    List<UserDTO> getAllUsers();


    Integer createUser(UserDTO user);

    void updateUser(Integer id, UserDTO userDTO);


    void deleteUserById(Integer id);


}
