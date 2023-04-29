package com.fashionlike.proyecto_fashion_like.domain.usecase;

import com.fashionlike.proyecto_fashion_like.domain.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostUseCase {
    Optional<Post> getPostById(Long id);

    List<Post> getAllPosts();

    void createPost(Long id, String title, String img, String description);

    void updatePost(Long id, String title, String img, String description);


    void deletePostById(Long id);
}
