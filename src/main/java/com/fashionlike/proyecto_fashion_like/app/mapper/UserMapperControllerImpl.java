package com.fashionlike.proyecto_fashion_like.app.mapper;

import com.fashionlike.proyecto_fashion_like.app.dto.RoleDTO;
import com.fashionlike.proyecto_fashion_like.app.dto.UserDTO;
import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.model.role.Role;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapperControllerImpl implements MapperController<User, UserDTO> {

    private final MapperController<Role, RoleDTO> roleMapperController;

    @Override
    public User toDomain(UserDTO dto) {
        Role role;
        if (dto == null) {
            return null;
        }
        role = roleMapperController.toDomain(dto.getRole());
        return User.builder()
                .id(dto.getId())
                .password(dto.getPassword())
                .name(dto.getName())
                .username(dto.getUsername())
                .isActive(dto.getIsActive())
                .role(role)
                .build();

    }

    @Override
    public UserDTO toDTO(User domain) {
        RoleDTO role;
        if (domain == null) {
            return null;
        }
        role = roleMapperController.toDTO(domain.getRole());
        return UserDTO.builder()
                .id(domain.getId())
                .username(domain.getUsername())
                .password(domain.getPassword())
                .name(domain.getName())
                .isActive(domain.getIsActive())
                .role(role)
                .build();
    }
}
