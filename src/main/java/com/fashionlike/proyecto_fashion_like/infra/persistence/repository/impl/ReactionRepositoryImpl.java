package com.fashionlike.proyecto_fashion_like.infra.persistence.repository.impl;

import com.fashionlike.proyecto_fashion_like.domain.model.Reaction;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.ReactionRepository;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.ReactionEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.mapper.MapperPersistence;
import com.fashionlike.proyecto_fashion_like.infra.persistence.repository.ReactionRepositoryPersistence;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class ReactionRepositoryImpl implements ReactionRepository {

    private final ReactionRepositoryPersistence persistence;
    private final MapperPersistence<ReactionEntity, Reaction> mapperPersistence;

    public ReactionRepositoryImpl(ReactionRepositoryPersistence persistence, MapperPersistence<ReactionEntity, Reaction> mapperPersistence) {
        this.persistence = persistence;
        this.mapperPersistence = mapperPersistence;
    }

    @Override
    public Reaction findById(Long id) {

        return persistence.findById(id)
                .map(mapperPersistence::toDomain)
                .orElse(null)
                ;
    }

    @Override
    public List<Reaction> findAll() {
        return persistence.findAll().stream()
                .map(mapperPersistence::toDomain)
                .collect(Collectors.toList())
                ;
    }

    @Override
    public void save(Reaction reaction) {
        ReactionEntity reactionEntity = mapperPersistence.toEntity(reaction);
        persistence.save(reactionEntity);
    }

    @Override
    public void deleteById(Long id) {
        persistence.deleteById(id);
    }
}
