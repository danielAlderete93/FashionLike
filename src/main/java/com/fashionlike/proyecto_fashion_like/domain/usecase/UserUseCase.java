package com.fashionlike.proyecto_fashion_like.domain.usecase;

import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.model.role.Role;

import java.util.List;
import java.util.Optional;

public interface UserUseCase {
    Optional<User> getUserById(Long id);

    List<User> getAllUsers();


    void createUser(Long id, String name, String username, String password, Role role);

    void updateUser(Long id, String name, String username, String password, Role role);


    void deleteUserById(Long id);


}
