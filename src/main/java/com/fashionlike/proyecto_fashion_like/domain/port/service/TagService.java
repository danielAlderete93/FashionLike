package com.fashionlike.proyecto_fashion_like.domain.port.service;

import com.fashionlike.proyecto_fashion_like.domain.model.Tag;

import java.util.List;

public interface TagService {
    Tag getTagById(Integer id);

    List<Tag> getAllTags();

    Integer createTag(Tag tag);

    void updateTag(Tag tag);

    Boolean deleteTagById(Integer id);
}
