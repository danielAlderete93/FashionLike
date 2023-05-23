package com.fashionlike.proyecto_fashion_like.domain.usecase;

import com.fashionlike.proyecto_fashion_like.app.dto.PostDTO;

import java.util.List;

public interface PostUseCase {
    PostDTO getPostById(Integer id);

    List<PostDTO> getAllPosts();

    Integer createPost(PostDTO post);

    void updatePost(Integer id, PostDTO post);

    void deletePostById(Integer id);
}
