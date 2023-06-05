package com.fashionlike.proyecto_fashion_like.domain.port.repository;

import com.fashionlike.proyecto_fashion_like.domain.model.Post;
import com.fashionlike.proyecto_fashion_like.domain.model.User;

import java.util.List;
import java.util.Optional;


public interface PostRepository {
    Optional<Post> findById(Integer id);

    List<Post> findAll();

    Integer save(Post post);

    Boolean deleteById(Integer id);

    boolean existsByTitle(String title);

    List<Post> findAllForAuthor(User author);
}
