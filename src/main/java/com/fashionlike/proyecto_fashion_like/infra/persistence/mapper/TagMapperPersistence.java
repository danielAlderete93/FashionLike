package com.fashionlike.proyecto_fashion_like.infra.persistence.mapper;

import com.fashionlike.proyecto_fashion_like.domain.model.Tag;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.TagEntity;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor
public class TagMapperPersistence implements MapperPersistence<TagEntity, Tag> {

    @Override
    public Optional<Tag> toDomain(TagEntity entity) {
        Tag tag;
        List<Tag> subTags;
        if (entity == null) {
            return Optional.empty();
        }

         subTags = entity.getTags().stream()
                .map(this::toDomain)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        tag = Tag.builder()
                .id(entity.getId())
                .name(entity.getName())
                .tags(subTags)
                .build();
        return Optional.of(tag);
    }

    @Override
    public Optional<TagEntity> toEntity(Tag domain) {
        TagEntity tagEntity;
        List<TagEntity> subTags;

        if(domain == null){
            return Optional.empty();
        }

        subTags = domain.getTags().stream()
                .map(this::toEntity)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        tagEntity = TagEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .tags(subTags)
                .build();
        return Optional.of(tagEntity);
    }
}
