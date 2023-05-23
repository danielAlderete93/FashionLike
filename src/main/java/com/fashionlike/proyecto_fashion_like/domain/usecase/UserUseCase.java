package com.fashionlike.proyecto_fashion_like.domain.usecase;

import com.fashionlike.proyecto_fashion_like.app.dto.UserDTO;
import com.fashionlike.proyecto_fashion_like.domain.exceptions.DomainException;

import java.util.List;

public interface UserUseCase {
    UserDTO getUserById(Integer id);

    List<UserDTO> getAllUsers();

    Integer createUser(UserDTO user) throws DomainException;

    void updateUser(Integer id, UserDTO user) throws DomainException;

    void deleteUserById(Integer id);
}