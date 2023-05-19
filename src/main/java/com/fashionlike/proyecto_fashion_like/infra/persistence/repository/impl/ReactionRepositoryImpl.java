package com.fashionlike.proyecto_fashion_like.infra.persistence.repository.impl;

import com.fashionlike.proyecto_fashion_like.domain.model.Reaction;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.ReactionRepository;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.ReactionEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.mapper.MapperPersistence;
import com.fashionlike.proyecto_fashion_like.infra.persistence.repository.ReactionRepositoryPersistenceJPA;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    public Reaction findById(Long id) {

        return reactionRepositoryPersistenceJPA.findById(id)
                .map(reactionMapperPersistence::toDomain)
                .orElse(null)
                ;
    }

    @Override
    public List<Reaction> findAll() {
        return reactionRepositoryPersistenceJPA.findAll().stream()
                .map(reactionMapperPersistence::toDomain)
                .collect(Collectors.toList())
                ;
    }

    @Transactional
    @Override
    public void save(Reaction reaction) {
        ReactionEntity reactionEntity = reactionMapperPersistence.toEntity(reaction);
        reactionRepositoryPersistenceJPA.save(reactionEntity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        reactionRepositoryPersistenceJPA.deleteById(id);
    }
}
