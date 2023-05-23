package com.fashionlike.proyecto_fashion_like.domain.port.repository;

import com.fashionlike.proyecto_fashion_like.domain.model.role.Role;

import java.util.List;
import java.util.Optional;

public interface RoleRepository {
    Optional<Role> findById(Integer id);

    List<Role> findAll();

    Integer save(Role role);

    Boolean deleteById(Integer id);

    boolean existsByTitle(String title);
}
