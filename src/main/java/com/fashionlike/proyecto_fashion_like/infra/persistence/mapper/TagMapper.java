package com.fashionlike.proyecto_fashion_like.infra.persistence.mapper;

import com.fashionlike.proyecto_fashion_like.domain.model.Tag;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.TagEntity;

import java.util.List;
import java.util.stream.Collectors;

public class TagMapper implements MapperPersistence<TagEntity, Tag> {
    @Override
    public Tag toDomain(TagEntity entity) {
        List<Tag> subTags;

        subTags = entity.getTags().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());

        return Tag.builder()
                .id(entity.getId())
                .name(entity.getName())
                .tags(subTags)
                .build();

    }

    @Override
    public TagEntity toEntity(Tag domain) {
        List<TagEntity> subTags;

        subTags = domain.getTags().stream()
                .map(this::toEntity)
                .collect(Collectors.toList());

        return TagEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .tags(subTags)
                .build();
    }
}
