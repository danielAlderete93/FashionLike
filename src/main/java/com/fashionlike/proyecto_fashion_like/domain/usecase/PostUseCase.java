package com.fashionlike.proyecto_fashion_like.domain.usecase;

import com.fashionlike.proyecto_fashion_like.app.usecase.post.dto.PostDTO;
import com.fashionlike.proyecto_fashion_like.app.usecase.post.dto.PostInfoDTO;

public interface PostUseCase {

    PostInfoDTO deactivate(Integer idPost);

    PostInfoDTO activate(Integer idPost);

    PostDTO addView(Integer idPost);


}

