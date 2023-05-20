package com.fashionlike.proyecto_fashion_like.infra.persistence.mapper;

import com.fashionlike.proyecto_fashion_like.domain.model.ReactionType;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.ReactionTypeEntity;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@NoArgsConstructor
public class ReactionTypeMapperPersistence implements MapperPersistence<ReactionTypeEntity, ReactionType> {
    @Override
    public Optional<ReactionType> toDomain(ReactionTypeEntity entity) {
        ReactionType reactionType;
        if (entity == null) {
            return Optional.empty();
        }
        reactionType = ReactionType.builder()
                .id(entity.getId())
                .name(entity.getName())
                .emoji(entity.getEmoji())
                .build();

        return Optional.of(reactionType);
    }

    @Override
    public Optional<ReactionTypeEntity> toEntity(ReactionType domain) {
        ReactionTypeEntity reactionType;

        if (domain == null) {
            return Optional.empty();
        }
        reactionType = ReactionTypeEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .emoji(domain.getEmoji())
                .build();

        return Optional.of(reactionType);

    }
}
