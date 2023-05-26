package com.fashionlike.proyecto_fashion_like.app.converter;

import com.fashionlike.proyecto_fashion_like.app.dto.ReactionTypeDTO;
import com.fashionlike.proyecto_fashion_like.domain.model.ReactionType;
import org.springframework.stereotype.Component;

@Component
public class ReactionTypeConverterDTOImpl implements ConverterDTO<ReactionType, ReactionTypeDTO> {
    @Override
    public ReactionType toDomain(ReactionTypeDTO dto) {

        if (dto == null) {
            return null;
        }

        return ReactionType.builder()
                .id(dto.getId())
                .name(dto.getName())
                .emoji(dto.getEmoji())
                .build();
    }

    @Override
    public ReactionTypeDTO toDTO(ReactionType domain) {
        if (domain == null) {
            return null;
        }
        return ReactionTypeDTO.builder()
                .id(domain.getId())
                .name(domain.getName())
                .emoji(domain.getEmoji())
                .build();
    }
}
