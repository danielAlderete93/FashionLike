package com.fashionlike.proyecto_fashion_like.infra.persistence.mapper;

import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.model.role.Role;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.RoleEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UserMapperPersistence implements MapperPersistence<UserEntity, User> {

    private final MapperPersistence<RoleEntity, Role> roleMapperPersistence;


    @Override
    public Optional<User> toDomain(UserEntity entity) {
        Role role;
        User user;
        if (entity == null) {
            return Optional.empty();
        }


        role = roleMapperPersistence.toDomain(entity.getRole()).orElse(null);
        user = User.builder().id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .name(entity.getName())
                .isActive(entity.getIsActive())
                .role(role)
                .build();

        return Optional.of(user);
    }

    @Override
    public Optional<UserEntity> toEntity(User domain) {
        RoleEntity role;
        UserEntity userEntity;

        if (domain == null) {
            return Optional.empty();
        }
        role = roleMapperPersistence.toEntity(domain.getRole())
                .orElse(null);

        userEntity = UserEntity.builder().id(domain.getId())
                .username(domain.getUsername())
                .password(domain.getPassword())
                .name(domain.getName())
                .isActive(domain.getIsActive())
                .role(role)
                .build();

        return Optional.of(userEntity);
    }
}
