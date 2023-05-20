package com.fashionlike.proyecto_fashion_like.app.service;

import com.fashionlike.proyecto_fashion_like.domain.model.role.Role;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.RoleRepository;
import com.fashionlike.proyecto_fashion_like.domain.port.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role getRoleById(Integer id) {

        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Integer createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void updateRole(Integer id, Role role) {
        roleRepository.findById(id)
                .ifPresent(roleToEdit -> roleToEdit.setAllowedActions(role.getAllowedActions()));

        roleRepository.save(role);

    }

    @Override
    public void deleteRoleById(Integer id) {
        roleRepository.deleteById(id);
    }
}
