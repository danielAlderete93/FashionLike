package com.fashionlike.proyecto_fashion_like.domain.port.service;

import com.fashionlike.proyecto_fashion_like.domain.model.Post;

import java.util.List;

public interface PostService {
    Post getPostById(Integer id);

    List<Post> getAllPosts();

    Integer createPost(Post post);

    void updatePost(Integer id, Post post);

    Boolean deletePostById(Integer id);
}
