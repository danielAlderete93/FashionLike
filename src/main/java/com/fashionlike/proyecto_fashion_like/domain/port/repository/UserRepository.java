package com.fashionlike.proyecto_fashion_like.domain.port.repository;

import com.fashionlike.proyecto_fashion_like.domain.model.User;


import java.util.List;


public interface UserRepository {
    User findById(Long id);

    List<User> findAll();

    void save(User user);

    void deleteById(Long id);
}
