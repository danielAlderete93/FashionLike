package com.fashionlike.proyecto_fashion_like.app.converter;

import com.fashionlike.proyecto_fashion_like.app.dto.RoleDTO;
import com.fashionlike.proyecto_fashion_like.domain.model.role.Role;
import com.fashionlike.proyecto_fashion_like.domain.model.role.RoleAdmin;
import com.fashionlike.proyecto_fashion_like.domain.model.role.RoleStandard;
import org.springframework.stereotype.Service;

@Service
public class RoleConverterDTOImpl implements ConverterDTO<Role, RoleDTO> {
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
        RoleDTO roleDTO;
        if (domain == null) {
            return null;
        }
        roleDTO = RoleDTO.builder()
                .id(domain.getId())
                .allowedActions(domain.getAllowedActions())
                .build();

        if (domain instanceof RoleAdmin) {
            roleDTO.setName("admin");
        }
        if (domain instanceof RoleStandard) {
            roleDTO.setName("standard");
        }

        return roleDTO;

    }

    private boolean isAdmin(RoleDTO dto) {
        return dto.getName().equalsIgnoreCase("admin");
    }

    private boolean isStandard(RoleDTO dto) {
        return dto.getName().equalsIgnoreCase("standard");
    }
}
