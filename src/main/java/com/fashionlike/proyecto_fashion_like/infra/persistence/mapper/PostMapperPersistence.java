package com.fashionlike.proyecto_fashion_like.infra.persistence.mapper;

import com.fashionlike.proyecto_fashion_like.domain.model.Post;
import com.fashionlike.proyecto_fashion_like.domain.model.Tag;
import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.PostEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.TagEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class PostMapperPersistence implements MapperPersistence<PostEntity, Post> {
    private MapperPersistence<TagEntity, Tag> tagMapperPersistence;
    private MapperPersistence<UserEntity, User> userMapperPersistence;


    @Override
    public Optional<Post> toDomain(PostEntity entity) {
        Post post;
        List<Tag> tagList;
        User user;
        if (entity == null) {
            return Optional.empty();
        }
        user = userMapperPersistence.toDomain(entity.getAuthor()).orElse(null);
        tagList = entity.getTags().stream()
                .map(tagMapperPersistence::toDomain)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        post = Post.builder()
                .id(entity.getId())
                .date(entity.getDate())
                .description(entity.getDescription())
                .img(entity.getImg())
                .title(entity.getTitle())
                .views(entity.getViews())
                .tags(tagList)
                .isActive(entity.getIsActive())
                .author(user)
                .build();

        return Optional.of(post);
    }

    @Override
    public Optional<PostEntity> toEntity(Post domain) {
        List<TagEntity> tagEntities;
        PostEntity postEntity;
        UserEntity userEntity;
        if (domain == null) {
            return Optional.empty();
        }

        userEntity = userMapperPersistence.toEntity(domain.getAuthor()).orElse(null);

        tagEntities = domain.getTags().stream()
                .map(tagMapperPersistence::toEntity)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        postEntity = PostEntity.builder()
                .id(domain.getId())
                .date(domain.getDate())
                .description(domain.getDescription())
                .img(domain.getImg())
                .title(domain.getTitle())
                .views(domain.getViews())
                .tags(tagEntities)
                .author(userEntity)
                .isActive(domain.getIsActive())
                .build();

        return Optional.of(postEntity);
    }
}
