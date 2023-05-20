package com.fashionlike.proyecto_fashion_like.app.mapper;

import com.fashionlike.proyecto_fashion_like.app.dto.RoleDTO;
import com.fashionlike.proyecto_fashion_like.domain.model.role.Role;
import com.fashionlike.proyecto_fashion_like.domain.model.role.RoleAdmin;
import com.fashionlike.proyecto_fashion_like.domain.model.role.RoleStandard;
import org.springframework.stereotype.Service;

@Service
public class RoleMapperControllerImpl implements MapperController<Role, RoleDTO> {
    @Override
    public Role toDomain(RoleDTO dto) {

        if (isAdmin(dto)) {
            return RoleAdmin.builder()
                    .id(dto.getId())
                    .allowedActions(dto.getAllowedActions())
                    .build();
        }

        if (isStandard(dto)) {
            return RoleStandard.builder()
                    .id(dto.getId())
                    .allowedActions(dto.getAllowedActions())
                    .build();
        }
        return null;
    }

    @Override
    public RoleDTO toDTO(Role domain) {
        if (domain != null) {
            return RoleDTO.builder()
                    .id(domain.getId())
                    .allowedActions(domain.getAllowedActions())
                    .build();
        }
        return null;
    }

    private boolean isAdmin(RoleDTO dto) {
        return dto.getName().equalsIgnoreCase("admin");
    }

    private boolean isStandard(RoleDTO dto) {
        return dto.getName().equalsIgnoreCase("standard");
    }
}
