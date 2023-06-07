package com.fashionlike.proyecto_fashion_like.app.api.builder.post;

import com.fashionlike.proyecto_fashion_like.app.api.builder.crud.AbstractApiCRUDResponseBuilder;
import com.fashionlike.proyecto_fashion_like.app.usecase.post.dto.PostDTO;


public abstract class PostApiCRUDResponseBuilder extends AbstractApiCRUDResponseBuilder<PostDTO> {

    @Override
    protected String getEntityName() {
        return "post";
    }
}
