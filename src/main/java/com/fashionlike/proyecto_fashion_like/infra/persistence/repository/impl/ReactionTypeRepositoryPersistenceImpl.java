package com.fashionlike.proyecto_fashion_like.infra.persistence.repository.impl;

import com.fashionlike.proyecto_fashion_like.domain.model.ReactionType;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.ReactionTypeRepository;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.ReactionTypeEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.mapper.MapperPersistence;
import com.fashionlike.proyecto_fashion_like.infra.persistence.repository.ReactionTypeRepositoryPersistenceJPA;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("reactionTypeRepositoryPersistenceImpl")
public class ReactionTypeRepositoryPersistenceImpl implements ReactionTypeRepository {

    private final ReactionTypeRepositoryPersistenceJPA reactionTypeRepositoryPersistenceJPA;
    private final MapperPersistence<ReactionTypeEntity, ReactionType> reactionTypeMapperPersistence;


    public ReactionTypeRepositoryPersistenceImpl(ReactionTypeRepositoryPersistenceJPA reactionTypeRepositoryPersistenceJPA,
                                                 MapperPersistence<ReactionTypeEntity, ReactionType> reactionTypeMapperPersistence) {
        this.reactionTypeRepositoryPersistenceJPA = reactionTypeRepositoryPersistenceJPA;
        this.reactionTypeMapperPersistence = reactionTypeMapperPersistence;
    }

    @Override
    public Optional<ReactionType> findById(Long id) {

        return reactionTypeRepositoryPersistenceJPA.findById(id)
                .map(reactionTypeMapperPersistence::toDomain)
                .orElse(null)
                ;
    }

    @Override
    public List<ReactionType> findAll() {
        List<ReactionTypeEntity> entities = reactionTypeRepositoryPersistenceJPA.findAll();

        return entities.stream()
                .map(reactionTypeMapperPersistence::toDomain)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Integer save(ReactionType reactionType) {
        Optional<ReactionTypeEntity> reactionTypeEntity = reactionTypeMapperPersistence.toEntity(reactionType);

        if (reactionTypeEntity.isEmpty()) {
            return null;
        }

        ReactionTypeEntity savedEntity = reactionTypeRepositoryPersistenceJPA.save(reactionTypeEntity.get());

        return savedEntity.getId();
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        reactionTypeRepositoryPersistenceJPA.deleteById(id);
    }
}
