package com.fashionlike.proyecto_fashion_like.domain.port.service;

import com.fashionlike.proyecto_fashion_like.domain.exceptions.DomainException;
import com.fashionlike.proyecto_fashion_like.domain.model.User;

import java.util.List;


public interface UserService {
    User getUserById(Integer id);

    List<User> getUsers();

    Integer createUser(User user) throws DomainException;

    void updateUser(Integer id, User user) throws DomainException;

    Boolean deleteUserById(Integer id);
}
