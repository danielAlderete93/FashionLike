package com.fashionlike.proyecto_fashion_like.domain.port.repository;

import com.fashionlike.proyecto_fashion_like.domain.model.User;

import java.util.List;


public interface UserRepository {
    User findById(Integer id);

    List<User> findAll();

    Integer save(User user);

    void deleteById(Integer id);
}
