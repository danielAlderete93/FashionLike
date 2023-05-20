package com.fashionlike.proyecto_fashion_like.infra.persistence.repository.impl;

import com.fashionlike.proyecto_fashion_like.domain.model.Tag;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.TagRepository;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.TagEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.mapper.MapperPersistence;
import com.fashionlike.proyecto_fashion_like.infra.persistence.repository.TagRepositoryPersistenceJPA;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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
    public Optional<Tag> findById(Long id) {
        return tagRepositoryPersistenceJPA.findById(id)
                .flatMap(tagMapperPersistence::toDomain);
    }

    @Override
    public List<Tag> findAll() {
        List<TagEntity> entities = tagRepositoryPersistenceJPA.findAll();

        return entities.stream()
                .map(tagMapperPersistence::toDomain)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Integer save(Tag tag) {
        Optional<TagEntity> tagEntity = tagMapperPersistence.toEntity(tag);

        if (tagEntity.isEmpty()) {
            return null;
        }

        TagEntity savedEntity = tagRepositoryPersistenceJPA.save(tagEntity.get());

        return savedEntity.getId();
    }

    @Transactional
    @Override
    public Boolean deleteById(Long id) {
        tagRepositoryPersistenceJPA.deleteById(id);
        return true;
    }
}
