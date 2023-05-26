package com.fashionlike.proyecto_fashion_like.app.api.builder;

import com.fashionlike.proyecto_fashion_like.app.dto.PostDTO;
import org.springframework.stereotype.Component;

@Component
public class PostApiResponseBuilder extends AbstractApiResponseBuilder<PostDTO> {

    @Override
    protected String getEntityName() {
        return "post";
    }
}
