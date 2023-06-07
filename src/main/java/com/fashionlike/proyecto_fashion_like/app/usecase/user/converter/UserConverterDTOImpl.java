package com.fashionlike.proyecto_fashion_like.app.usecase.user.converter;


import com.fashionlike.proyecto_fashion_like.app.usecase.converter.ConverterDTO;
import com.fashionlike.proyecto_fashion_like.app.usecase.user.dto.UserDTO;
import com.fashionlike.proyecto_fashion_like.domain.model.Role;
import com.fashionlike.proyecto_fashion_like.domain.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserConverterDTOImpl implements ConverterDTO<User, UserDTO> {


    @Override
    public User toDomain(UserDTO dto) {

        if (dto == null) {
            return null;
        }

        return User.builder()
                .id(dto.getId())
                .password(dto.getPassword())
                .name(dto.getName())
                .username(dto.getUsername())
                .isActive(dto.getIsActive())
                .mail(dto.getMail())
                .role(Role.valueOf(dto.getRole()))
                .build();

    }

    @Override
    public UserDTO toDTO(User domain) {
        if (domain == null) {
            return null;
        }
        return UserDTO.builder()
                .id(domain.getId())
                .username(domain.getUsername())
                .password(domain.getPassword())
                .name(domain.getName())
                .mail(domain.getMail())
                .isActive(domain.getIsActive())
                .role(domain.getRole().name())
                .build();
    }
}
