package com.fashionlike.proyecto_fashion_like.infra.persistence.repository.impl;

import com.fashionlike.proyecto_fashion_like.domain.model.ReactionType;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.ReactionTypeRepository;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.ReactionTypeEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.mapper.MapperPersistence;
import com.fashionlike.proyecto_fashion_like.infra.persistence.repository.ReactionTypeRepositoryPersistence;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReactionTypeRepositoryPersistenceImpl implements ReactionTypeRepository {

    private final ReactionTypeRepositoryPersistence persistence;
    private final MapperPersistence<ReactionTypeEntity, ReactionType> mapperPersistence;

    public ReactionTypeRepositoryPersistenceImpl(ReactionTypeRepositoryPersistence persistence, MapperPersistence<ReactionTypeEntity, ReactionType> mapperPersistence) {
        this.persistence = persistence;
        this.mapperPersistence = mapperPersistence;
    }

    @Override
    public ReactionType findById(Long id) {

        return persistence.findById(id)
                .map(mapperPersistence::toDomain)
                .orElse(null)
                ;
    }

    @Override
    public List<ReactionType> findAll() {
        return persistence.findAll().stream()
                .map(mapperPersistence::toDomain)
                .collect(Collectors.toList())
                ;
    }

    @Override
    public void save(ReactionType reactionType) {
        ReactionTypeEntity entity = mapperPersistence.toEntity(reactionType);
        persistence.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        persistence.deleteById(id);
    }
}
