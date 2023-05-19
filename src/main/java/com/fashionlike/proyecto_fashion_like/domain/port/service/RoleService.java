package com.fashionlike.proyecto_fashion_like.domain.port.service;

import com.fashionlike.proyecto_fashion_like.domain.model.role.Role;

import java.util.List;

public interface RoleService {
    Role getRoleById(Integer id);

    List<Role> getRoles();

    Integer createRole(Role role);

    void updateRole(Integer id, Role role);

    void deleteRoleById(Integer id);
}
