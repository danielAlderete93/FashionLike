package com.fashionlike.proyecto_fashion_like.domain.port.repository;

import com.fashionlike.proyecto_fashion_like.domain.model.Tag;

import java.util.List;
import java.util.Optional;

public interface TagRepository {
    Optional<Tag> findById(Long id);

    List<Tag> findAll();

    Integer save(Tag tag);

    Boolean deleteById(Long id);
}
