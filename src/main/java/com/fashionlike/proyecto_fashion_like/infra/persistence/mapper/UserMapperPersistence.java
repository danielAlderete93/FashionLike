package com.fashionlike.proyecto_fashion_like.infra.persistence.mapper;

import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.model.role.RoleAdmin;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.UserEntity;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class UserMapperPersistence implements MapperPersistence<UserEntity, User> {
    @Override
    public User toDomain(UserEntity entity) {
        return User.builder().id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .name(entity.getPassword())
                .role(new RoleAdmin()) //TODO: Ojo!
                .build();
    }

    @Override
    public UserEntity toEntity(User domain) {
        return UserEntity.builder().id(domain.getId())
                .username(domain.getUsername())
                .password(domain.getPassword())
                .name(domain.getPassword())
                //.rol(new RoleAdmin()) //TODO: Ojo!
                .build();
    }
}
