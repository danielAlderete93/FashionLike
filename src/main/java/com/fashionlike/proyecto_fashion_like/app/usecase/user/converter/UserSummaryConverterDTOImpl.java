package com.fashionlike.proyecto_fashion_like.app.usecase.user.converter;

import com.fashionlike.proyecto_fashion_like.app.usecase.converter.ConverterDTO;
import com.fashionlike.proyecto_fashion_like.app.usecase.user.dto.UserSummaryDTO;
import com.fashionlike.proyecto_fashion_like.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserSummaryConverterDTOImpl implements ConverterDTO<User, UserSummaryDTO> {
    @Override
    public User toDomain(UserSummaryDTO dto) {
        return null;
    }

    @Override
    public UserSummaryDTO toDTO(User domain) {
        return UserSummaryDTO.builder()
                .role(domain.getRole().name())
                .username(domain.getUsername())
                .mail(domain.getMail())
                .name(domain.getName())
                .build();
    }
}
