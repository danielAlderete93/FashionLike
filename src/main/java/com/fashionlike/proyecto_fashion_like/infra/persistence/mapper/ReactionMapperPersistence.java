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


@Component
@AllArgsConstructor
@NoArgsConstructor
public class ReactionMapperPersistence implements MapperPersistence<ReactionEntity, Reaction> {
    private MapperPersistence<UserEntity, User> userMapperPersistence;
    private MapperPersistence<PostEntity, Post> postMapperPersistence;

    private MapperPersistence<ReactionTypeEntity, ReactionType> reactionTypeMapperPersistence;


    @Override
    public Reaction toDomain(ReactionEntity entity) {
        User user = userMapperPersistence.toDomain(entity.getUser());
        Post post = postMapperPersistence.toDomain(entity.getPost());
        ReactionType type = reactionTypeMapperPersistence.toDomain(entity.getType());


        return Reaction.builder().id(entity.getId()).post(post).type(type).user(user).build();
    }

    @Override
    public ReactionEntity toEntity(Reaction domain) {
        UserEntity userEntity = userMapperPersistence.toEntity(domain.getUser());
        PostEntity postEntity = postMapperPersistence.toEntity(domain.getPost());
        ReactionTypeEntity typeEntity = reactionTypeMapperPersistence.toEntity(domain.getType());

        return ReactionEntity.builder().id(domain.getId()).post(postEntity).type(typeEntity).user(userEntity).build();
    }
}
