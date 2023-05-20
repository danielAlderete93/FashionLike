package com.fashionlike.proyecto_fashion_like.infra.persistence.mapper;

import com.fashionlike.proyecto_fashion_like.domain.model.Post;
import com.fashionlike.proyecto_fashion_like.domain.model.Reaction;
import com.fashionlike.proyecto_fashion_like.domain.model.ReactionType;
import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.PostEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.ReactionEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.ReactionTypeEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@AllArgsConstructor
@NoArgsConstructor
public class ReactionMapperPersistence implements MapperPersistence<ReactionEntity, Reaction> {
    private MapperPersistence<UserEntity, User> userMapperPersistence;
    private MapperPersistence<PostEntity, Post> postMapperPersistence;

    private MapperPersistence<ReactionTypeEntity, ReactionType> reactionTypeMapperPersistence;


    @Override
    public Optional<Reaction> toDomain(ReactionEntity entity) {
        User user;
        Post post;
        ReactionType type;
        Reaction reaction;

        if (entity == null) {
            return Optional.empty();
        }
        user = userMapperPersistence.toDomain(entity.getUser())
                .orElse(null);
        post = postMapperPersistence.toDomain(entity.getPost())
                .orElse(null);
        type = reactionTypeMapperPersistence.toDomain(entity.getType())
                .orElse(null);

        reaction = Reaction.builder()
                .id(entity.getId())
                .post(post)
                .type(type)
                .user(user)
                .build();

        return Optional.of(reaction);
    }

    @Override
    public Optional<ReactionEntity> toEntity(Reaction domain) {
        UserEntity userEntity;
        PostEntity postEntity;
        ReactionTypeEntity typeEntity;
        ReactionEntity entity;

        if (domain == null) {
            return Optional.empty();
        }
        userEntity = userMapperPersistence.toEntity(domain.getUser())
                .orElse(null);
        postEntity = postMapperPersistence.toEntity(domain.getPost())
                .orElse(null);
        typeEntity = reactionTypeMapperPersistence.toEntity(domain.getType())
                .orElse(null);

        entity = ReactionEntity.builder()
                .id(domain.getId())
                .post(postEntity)
                .type(typeEntity)
                .user(userEntity)
                .build();

        return Optional.of(entity);
    }
}
