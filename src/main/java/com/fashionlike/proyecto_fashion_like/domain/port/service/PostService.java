package com.fashionlike.proyecto_fashion_like.domain.port.service;

import com.fashionlike.proyecto_fashion_like.domain.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Optional<Post> getPostById(Long id);

    List<Post> getAllPosts();

    void createPost(Post post);

    void updatePost(Post post);

    void deletePostById(Long id);
}
