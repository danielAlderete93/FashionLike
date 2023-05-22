package com.fashionlike.proyecto_fashion_like.domain.port.repository;

import com.fashionlike.proyecto_fashion_like.domain.model.User;

import java.util.List;
import java.util.Optional;


public interface UserRepository {
    Optional<User> findById(Integer id);

    List<User> findAll();

    Integer save(User user);

    Boolean deleteById(Integer id);

    boolean existsByUsername(String username);
}