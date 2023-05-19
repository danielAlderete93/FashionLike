package com.fashionlike.proyecto_fashion_like.domain.port.repository;

import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.model.role.Role;

import java.util.List;

public interface RoleRepository {
    Role findById(Integer id);

    List<Role> findAll();

    Integer save(Role role);

    void deleteById(Integer id);
}
