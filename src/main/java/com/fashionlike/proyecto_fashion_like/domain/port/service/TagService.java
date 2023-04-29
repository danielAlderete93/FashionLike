package com.fashionlike.proyecto_fashion_like.domain.port.service;

import com.fashionlike.proyecto_fashion_like.domain.model.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {
    Optional<Tag> getTagById(Long id);

    List<Tag> getAllTags();

    void createTag(Tag tag);

    void updateTag(Tag tag);

    void deleteTagById(Long id);
}
