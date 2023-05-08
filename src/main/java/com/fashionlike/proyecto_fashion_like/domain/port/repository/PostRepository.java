package com.fashionlike.proyecto_fashion_like.domain.port.repository;

import com.fashionlike.proyecto_fashion_like.domain.model.Post;

import java.util.List;


public interface PostRepository {
    Post findById(Long id);

    List<Post> findAll();

    void save(Post post);

    void deleteById(Long id);
}
