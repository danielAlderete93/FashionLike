package com.fashionlike.proyecto_fashion_like.domain.usecase;

import com.fashionlike.proyecto_fashion_like.domain.model.Tag;

import java.util.List;
import java.util.Optional;

public interface TagUseCase {
    Optional<Tag> getTagById(Long id);

    List<Tag> getAllTags();

    void createTag(Long id, String name, List<Tag> tags);

    void updateTag(Long id, String name, List<Tag> tags);

    void deleteTagById(Long id);
}
