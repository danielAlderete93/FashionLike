package com.fashionlike.proyecto_fashion_like.infra.persistence.mapper;

import com.fashionlike.proyecto_fashion_like.domain.model.role.Role;
import com.fashionlike.proyecto_fashion_like.domain.model.role.RoleAdmin;
import com.fashionlike.proyecto_fashion_like.domain.model.role.RoleStandard;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.RoleAdminEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.RoleEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.RoleStandardEntity;
import org.springframework.stereotype.Component;

@Component
public class RoleMapperPersistence implements MapperPersistence<RoleEntity, Role> {
    @Override
    public Role toDomain(RoleEntity entity) {
        if (entity instanceof RoleStandardEntity) {
            return RoleStandard.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .allowedActions(entity.getAllowedActions())
                    .build();
        }
        if (entity instanceof RoleAdminEntity) {
            return RoleAdmin.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .allowedActions(entity.getAllowedActions())
                    .build();
        }
        return null;
    }

    @Override
    public RoleEntity toEntity(Role domain) {
        if (domain instanceof RoleStandard) {
            return RoleStandardEntity.builder()
                    .id(domain.getId())
                    .name(domain.getName())
                    .allowedActions(domain.getAllowedActions())
                    .build();
        }
        if (domain instanceof RoleAdmin) {
            return RoleAdminEntity.builder()
                    .id(domain.getId())
                    .name(domain.getName())
                    .allowedActions(domain.getAllowedActions())
                    .build();
        }
        return null;
    }
}
