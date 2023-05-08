package com.fashionlike.proyecto_fashion_like.infra.persistence.mapper;

import com.fashionlike.proyecto_fashion_like.domain.model.ReactionType;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.ReactionTypeEntity;

public class ReactionTypeMapper implements MapperPersistence<ReactionTypeEntity, ReactionType> {
    @Override
    public ReactionType toDomain(ReactionTypeEntity entity) {

        return ReactionType.builder()
                .id(entity.getId())
                .name(entity.getName())
                .emoji(entity.getEmoji())
                .build();
    }

    @Override
    public ReactionTypeEntity toEntity(ReactionType domain) {
        return ReactionTypeEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .emoji(domain.getEmoji())
                .build();
    }
}
