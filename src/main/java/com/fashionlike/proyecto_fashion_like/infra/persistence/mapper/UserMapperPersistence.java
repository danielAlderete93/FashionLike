package com.fashionlike.proyecto_fashion_like.infra.persistence.mapper;

import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UserMapperPersistence implements MapperPersistence<UserEntity, User> {


    @Override
    public Optional<User> toDomain(UserEntity entity) {
        User user;
        if (entity == null) {
            return Optional.empty();
        }


        user = User.builder().id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .name(entity.getName())
                .isActive(entity.getIsActive())
                .role(entity.getRole())
                .build();

        return Optional.of(user);
    }

    @Override
    public Optional<UserEntity> toEntity(User domain) {
        UserEntity userEntity;

        if (domain == null) {
            return Optional.empty();
        }


        userEntity = UserEntity.builder().id(domain.getId())
                .username(domain.getUsername())
                .password(domain.getPassword())
                .name(domain.getName())
                .isActive(domain.getIsActive())
                .role(domain.getRole())
                .build();

        return Optional.of(userEntity);
    }
}
