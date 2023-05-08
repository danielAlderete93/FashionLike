package com.fashionlike.proyecto_fashion_like.infra.persistence.repository.impl;

import com.fashionlike.proyecto_fashion_like.domain.model.Tag;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.TagRepository;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.TagEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.mapper.MapperPersistence;
import com.fashionlike.proyecto_fashion_like.infra.persistence.repository.TagRepositoryPersistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TagRepositoryPersistenceImpl implements TagRepository {
    private final TagRepositoryPersistence persistence;
    private final MapperPersistence<TagEntity, Tag> mapperPersistence;

    public TagRepositoryPersistenceImpl(TagRepositoryPersistence persistence, MapperPersistence<TagEntity, Tag> mapperPersistence) {
        this.persistence = persistence;
        this.mapperPersistence = mapperPersistence;
    }

    @Override
    public Tag findById(Long id) {
        return persistence.findById(id)
                .map(mapperPersistence::toDomain)
                .orElse(null)
                ;
    }

    @Override
    public List<Tag> findAll() {
        return persistence.findAll().stream()
                .map(mapperPersistence::toDomain)
                .collect(Collectors.toList())
                ;
    }

    @Override
    public void save(Tag tag) {
        TagEntity tagEntity = mapperPersistence.toEntity(tag);
        persistence.save(tagEntity);
    }

    @Override
    public void deleteById(Long id) {
        persistence.deleteById(id);
    }
}
