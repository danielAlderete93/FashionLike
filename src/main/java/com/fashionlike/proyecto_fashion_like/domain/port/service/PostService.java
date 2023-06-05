package com.fashionlike.proyecto_fashion_like.domain.port.service;

import com.fashionlike.proyecto_fashion_like.domain.model.Post;
import com.fashionlike.proyecto_fashion_like.domain.model.User;

import java.util.List;

public interface PostService extends CRUDBaseService<Post> {

    List<Post> getPostFromAuthor(User user);
}
