package com.fashionlike.proyecto_fashion_like.domain.port.service;

import com.fashionlike.proyecto_fashion_like.domain.model.Reaction;

import java.util.List;
import java.util.Optional;

public interface ReactionService {
    Optional<Reaction> getReactionById(Long id);

    List<Reaction> getAllReactions();

    void createReaction(Reaction reaction);

    void updateReaction(Reaction reaction);

    void deleteReactionById(Long id);
}
