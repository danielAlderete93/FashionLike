package com.fashionlike.proyecto_fashion_like.domain.usecase;

import com.fashionlike.proyecto_fashion_like.domain.model.Post;
import com.fashionlike.proyecto_fashion_like.domain.model.Reaction;
import com.fashionlike.proyecto_fashion_like.domain.model.ReactionType;
import com.fashionlike.proyecto_fashion_like.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface ReactionUseCase {
    Optional<Reaction> getReactionById(Long id);

    List<Reaction> getAllReactions();

    void createReaction(Long id, User user, Post post, ReactionType reactionType);

    void updateReaction(Long id, User user, Post post, ReactionType reactionType);

    void deleteReactionById(Long id);
}
