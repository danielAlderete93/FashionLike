package com.fashionlike.proyecto_fashion_like.domain.usecase;

import com.fashionlike.proyecto_fashion_like.domain.model.ReactionType;

import java.util.List;
import java.util.Optional;

public interface ReactionTypeUseCase {
    Optional<ReactionType> getReactionTypeById(Long id);

    List<ReactionType> getAllReactionType();

    void createReactionType(Long id, String name, Character emoji);

    void updateReactionType(Long id, String name, Character emoji);

    void deleteReactionTypeById(Long id);
}
