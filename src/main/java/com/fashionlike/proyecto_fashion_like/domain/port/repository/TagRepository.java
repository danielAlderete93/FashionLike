package com.fashionlike.proyecto_fashion_like.domain.port.repository;

import com.fashionlike.proyecto_fashion_like.domain.model.Tag;

import java.util.List;

public interface TagRepository {
    Tag findById(Long id);

    List<Tag> findAll();

    void save(Tag tag);

    void deleteById(Long id);
}
