package com.fashionlike.proyecto_fashion_like.infra.persistence.mapper;

import com.fashionlike.proyecto_fashion_like.domain.model.Role;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.RoleEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoleMapperPersistence implements MapperPersistence<RoleEntity, Role> {

    @Override
    public Optional<Role> toDomain(RoleEntity entity) {
        Role role;
        if (entity == null) {
            return Optional.empty();
        }
        role = entity.getRole();

        return Optional.of(role);
    }

    @Override
    public Optional<RoleEntity> toEntity(Role domain) {
        RoleEntity roleEntity;
        if (domain == null) {
            return Optional.empty();
        }
        roleEntity = RoleEntity.builder()
                .id(domain.ordinal())
                .role(domain)
                .build();

        return Optional.of(roleEntity);
    }
}
