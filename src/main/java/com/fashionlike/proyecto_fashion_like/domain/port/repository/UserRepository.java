package com.fashionlike.proyecto_fashion_like.domain.port.repository;

import com.fashionlike.proyecto_fashion_like.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);

    List<User> findAll();

    void save(User user);

    void deleteById(Long id);
}
