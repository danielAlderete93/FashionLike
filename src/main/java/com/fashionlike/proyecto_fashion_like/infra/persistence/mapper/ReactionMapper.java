package com.fashionlike.proyecto_fashion_like.infra.persistence.mapper;

import com.fashionlike.proyecto_fashion_like.domain.model.Post;
import com.fashionlike.proyecto_fashion_like.domain.model.Reaction;
import com.fashionlike.proyecto_fashion_like.domain.model.ReactionType;
import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.PostEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.ReactionEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.ReactionTypeEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.UserEntity;

public class ReactionMapper implements MapperPersistence<ReactionEntity, Reaction> {
    private MapperPersistence<UserEntity, User> userMapper;
    private MapperPersistence<PostEntity, Post> postMapper;

    private MapperPersistence<ReactionTypeEntity, ReactionType> reactionTypeMapper;


    @Override
    public Reaction toDomain(ReactionEntity entity) {
        User user = userMapper.toDomain(entity.getUser());
        Post post = postMapper.toDomain(entity.getPost());
        ReactionType type = reactionTypeMapper.toDomain(entity.getType());


        return Reaction.builder()
                .id(entity.getId())
                .post(post)
                .type(type)
                .user(user)
                .build();
    }

    @Override
    public ReactionEntity toEntity(Reaction domain) {
        UserEntity userEntity = userMapper.toEntity(domain.getUser());
        PostEntity postEntity = postMapper.toEntity(domain.getPost());
        ReactionTypeEntity typeEntity = reactionTypeMapper.toEntity(domain.getType());

        return ReactionEntity.builder()
                .id(domain.getId())
                .post(postEntity)
                .type(typeEntity)
                .user(userEntity)
                .build();
    }
}
