package com.fashionlike.proyecto_fashion_like.domain.port.repository;

import com.fashionlike.proyecto_fashion_like.domain.model.ReactionType;

import java.util.List;

public interface ReactionTypeRepository {
    ReactionType findById(Long id);

    List<ReactionType> findAll();

    void save(ReactionType reactionType);

    void deleteById(Long id);
}
