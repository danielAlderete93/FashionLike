package com.fashionlike.proyecto_fashion_like.domain.usecase;

import com.fashionlike.proyecto_fashion_like.app.usecase.post.dto.PostInfoDTO;

public interface PostUseCase {

    PostInfoDTO deactive(Integer idPost);

    PostInfoDTO active(Integer idPost);
}

