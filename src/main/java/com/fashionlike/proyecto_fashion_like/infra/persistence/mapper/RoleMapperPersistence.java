package com.fashionlike.proyecto_fashion_like.infra.persistence.mapper;

import com.fashionlike.proyecto_fashion_like.domain.model.role.Role;
import com.fashionlike.proyecto_fashion_like.domain.model.role.RoleAdmin;
import com.fashionlike.proyecto_fashion_like.domain.model.role.RoleStandard;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.RoleAdminEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.RoleEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.RoleStandardEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoleMapperPersistence implements MapperPersistence<RoleEntity, Role> {
    @Override
    public Optional<Role> toDomain(RoleEntity entity) {
        if (entity == null) {
            return Optional.empty();
        }

        if (entity instanceof RoleStandardEntity) {
            return Optional.of(
                    RoleStandard.builder()
                            .id(entity.getId())
                            .allowedActions(entity.getAllowedActions())
                            .build());
        }
        if (entity instanceof RoleAdminEntity) {
            return Optional.of(
                    RoleAdmin.builder()
                            .id(entity.getId())
                            .allowedActions(entity.getAllowedActions())
                            .build());
        }
        return Optional.empty();
    }

    @Override
    public Optional<RoleEntity> toEntity(Role domain) {
        if (domain instanceof RoleStandard) {
            return Optional.of(
                    RoleStandardEntity.builder()
                            .id(domain.getId())
                            .allowedActions(domain.getAllowedActions())
                            .build());
        }
        if (domain instanceof RoleAdmin) {
            return Optional.of(
                    RoleAdminEntity.builder()
                            .id(domain.getId())
                            .allowedActions(domain.getAllowedActions())
                            .build());
        }
        return Optional.empty();
    }
}
