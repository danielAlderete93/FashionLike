package com.fashionlike.proyecto_fashion_like.app.mapper;

import com.fashionlike.proyecto_fashion_like.app.dto.UserDTO;
import com.fashionlike.proyecto_fashion_like.domain.model.User;

import java.util.Map;

public class UserMapperControllerImpl implements MapperController<UserDTO, User> {
    @Override
    public User toDomain(UserDTO dto) {
        return User.builder()
                .id(dto.getId())
                .password(dto.getPassword())
                .name(dto.getName())
                .username(dto.getUsername())
                .build();

    }

    @Override
    public UserDTO toDTO(User domain) {
        return UserDTO.builder()
                .id(domain.getId())
                .username(domain.getUsername())
                .password(domain.getPassword())
                .name(domain.getName())
                .build();
    }
}
