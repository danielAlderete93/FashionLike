package com.fashionlike.proyecto_fashion_like.domain.port.repository;

import com.fashionlike.proyecto_fashion_like.domain.model.ReactionType;

import java.util.List;
import java.util.Optional;

public interface ReactionTypeRepository {
    Optional<ReactionType> findById(Long id);

    List<ReactionType> findAll();

    Integer save(ReactionType reactionType);

    void deleteById(Long id);
}
