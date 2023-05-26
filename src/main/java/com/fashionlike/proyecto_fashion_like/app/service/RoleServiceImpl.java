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
    public Role getById(Integer id) {

        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Integer create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void update(Integer id, Role role) {
        roleRepository.findById(id)
                .ifPresent(roleToEdit -> roleToEdit.setAllowedActions(role.getAllowedActions()));

        roleRepository.save(role);

    }

    @Override
    public Boolean deleteById(Integer id) {
        return roleRepository.deleteById(id);
    }
}
