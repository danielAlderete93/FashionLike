package com.fashionlike.proyecto_fashion_like.domain.port.repository;

import com.fashionlike.proyecto_fashion_like.domain.model.Reaction;

import java.util.List;
import java.util.Optional;

public interface ReactionRepository {
    Optional<Reaction> findById(Long id);

    List<Reaction> findAll();

    Integer save(Reaction reaction);

    Boolean deleteById(Long id);
}
