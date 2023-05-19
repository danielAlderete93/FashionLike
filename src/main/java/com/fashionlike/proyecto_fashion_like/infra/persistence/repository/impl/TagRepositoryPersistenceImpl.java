package com.fashionlike.proyecto_fashion_like.infra.persistence.repository.impl;

import com.fashionlike.proyecto_fashion_like.domain.model.Tag;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.TagRepository;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.TagEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.mapper.MapperPersistence;
import com.fashionlike.proyecto_fashion_like.infra.persistence.repository.TagRepositoryPersistenceJPA;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Repository
public class TagRepositoryPersistenceImpl implements TagRepository {
    private final TagRepositoryPersistenceJPA tagRepositoryPersistenceJPA;
    private final MapperPersistence<TagEntity, Tag> tagMapperPersistence;

    public TagRepositoryPersistenceImpl(TagRepositoryPersistenceJPA tagRepositoryPersistenceJPA, MapperPersistence<TagEntity, Tag> tagMapperPersistence) {
        this.tagRepositoryPersistenceJPA = tagRepositoryPersistenceJPA;
        this.tagMapperPersistence = tagMapperPersistence;
    }

    @Override
    public Tag findById(Long id) {
        return tagRepositoryPersistenceJPA.findById(id).map(tagMapperPersistence::toDomain).orElse(null);
    }

    @Override
    public List<Tag> findAll() {
        return tagRepositoryPersistenceJPA.findAll().stream().map(tagMapperPersistence::toDomain).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void save(Tag tag) {
        TagEntity tagEntity = tagMapperPersistence.toEntity(tag);
        tagRepositoryPersistenceJPA.save(tagEntity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        tagRepositoryPersistenceJPA.deleteById(id);
    }
}
