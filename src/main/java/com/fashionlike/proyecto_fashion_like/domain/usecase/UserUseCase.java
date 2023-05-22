package com.fashionlike.proyecto_fashion_like.domain.usecase;

import com.fashionlike.proyecto_fashion_like.app.dto.UserDTO;
import com.fashionlike.proyecto_fashion_like.domain.exceptions.UserDomainException;

import java.util.List;

public interface UserUseCase {
    UserDTO getUserById(Integer id);

    List<UserDTO> getAllUsers();

    Integer createUser(UserDTO user) throws UserDomainException;

    void updateUser(Integer id, UserDTO user) throws UserDomainException;

    void deleteUserById(Integer id);
}