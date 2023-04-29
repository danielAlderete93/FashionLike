package com.fashionlike.proyecto_fashion_like.domain.port.service;

import com.fashionlike.proyecto_fashion_like.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(Long id);

    List<User> getUserPosts();

    void createUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);
}
