package com.fashionlike.proyecto_fashion_like.infra.persistence.mapper;

import com.fashionlike.proyecto_fashion_like.domain.model.Post;
import com.fashionlike.proyecto_fashion_like.domain.model.Tag;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.PostEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.TagEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class PostMapperPersistence implements MapperPersistence<PostEntity, Post> {
    private MapperPersistence<TagEntity, Tag> tagMapperPersistence;


    @Override
    public Post toDomain(PostEntity entity) {
        List<Tag> tagList;

        tagList = entity.getTags().stream().map(tagEntity -> tagMapperPersistence.toDomain(tagEntity)).collect(Collectors.toList());

        return Post.builder()
                .id(entity.getId())
                .date(entity.getDate())
                .description(entity.getDescription())
                .img(entity.getImg())
                .title(entity.getTitle())
                .views(entity.getViews())
                .tags(tagList)
                .isActive(entity.getIsActive())
                .build();
    }

    @Override
    public PostEntity toEntity(Post domain) {
        List<TagEntity> tagEntities;

        tagEntities = domain.getTags().stream().map(tag -> tagMapperPersistence.toEntity(tag)).collect(Collectors.toList());

        return PostEntity.builder()
                .id(domain.getId())
                .date(domain.getDate())
                .description(domain.getDescription())
                .img(domain.getImg())
                .title(domain.getTitle())
                .views(domain.getViews())
                .tags(tagEntities)
                .isActive(domain.getIsActive())
                .build();
    }
}
