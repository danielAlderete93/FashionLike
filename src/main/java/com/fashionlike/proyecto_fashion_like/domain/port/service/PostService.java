package com.fashionlike.proyecto_fashion_like.domain.port.service;

import com.fashionlike.proyecto_fashion_like.domain.model.Post;

import java.util.List;

public interface PostService {
    Post getPostById(Long id);

    List<Post> getAllPosts();

    void createPost(Post post);

    void updatePost(Long id, Post post);

    void deletePostById(Long id);
}
