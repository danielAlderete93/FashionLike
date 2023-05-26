package com.fashionlike.proyecto_fashion_like.infra.persistence.repository.impl;

import com.fashionlike.proyecto_fashion_like.domain.model.Reaction;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.ReactionRepository;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.ReactionEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.mapper.MapperPersistence;
import com.fashionlike.proyecto_fashion_like.infra.persistence.repository.ReactionRepositoryPersistenceJPA;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("reactionRepositoryImpl")
public class ReactionRepositoryImpl implements ReactionRepository {

    private final ReactionRepositoryPersistenceJPA reactionRepositoryPersistenceJPA;
    private final MapperPersistence<ReactionEntity, Reaction> reactionMapperPersistence;


    public ReactionRepositoryImpl(
            ReactionRepositoryPersistenceJPA reactionRepositoryPersistenceJPA,
            MapperPersistence<ReactionEntity, Reaction> reactionMapperPersistence) {
        this.reactionRepositoryPersistenceJPA = reactionRepositoryPersistenceJPA;
        this.reactionMapperPersistence = reactionMapperPersistence;
    }

    @Override
    public Optional<Reaction> findById(Long id) {
        return reactionRepositoryPersistenceJPA.findById(id)
                .flatMap(reactionMapperPersistence::toDomain);
    }

    @Override
    public List<Reaction> findAll() {
        List<ReactionEntity> entities = reactionRepositoryPersistenceJPA.findAll();

        return entities.stream()
                .map(reactionMapperPersistence::toDomain)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Integer save(Reaction reaction) {
        Optional<ReactionEntity> reactionEntity = reactionMapperPersistence.toEntity(reaction);

        if (reactionEntity.isEmpty()) {
            return null;
        }

        ReactionEntity savedEntity = reactionRepositoryPersistenceJPA.save(reactionEntity.get());

        return savedEntity.getId();
    }

    @Transactional
    @Override
    public Boolean deleteById(Long id) {
        if (!reactionRepositoryPersistenceJPA.existsById(id)) {
            return false;
        }

        reactionRepositoryPersistenceJPA.deleteById(id);
        return true;
    }
}
