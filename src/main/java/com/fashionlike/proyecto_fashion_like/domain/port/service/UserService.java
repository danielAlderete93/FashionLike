package com.fashionlike.proyecto_fashion_like.domain.port.service;

import com.fashionlike.proyecto_fashion_like.domain.model.User;


public interface UserService extends CRUDBaseService<User> {
    User findByUsername(String username);

}
