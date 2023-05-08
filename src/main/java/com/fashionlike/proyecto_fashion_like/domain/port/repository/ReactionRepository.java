package com.fashionlike.proyecto_fashion_like.domain.port.repository;

import com.fashionlike.proyecto_fashion_like.domain.model.Reaction;

import java.util.List;

public interface ReactionRepository {
    Reaction findById(Long id);

    List<Reaction> findAll();

    void save(Reaction reaction);

    void deleteById(Long id);
}
