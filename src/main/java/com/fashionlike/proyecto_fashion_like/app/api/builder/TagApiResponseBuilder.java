package com.fashionlike.proyecto_fashion_like.app.api.builder;

import com.fashionlike.proyecto_fashion_like.app.dto.TagDTO;
import org.springframework.stereotype.Component;

@Component
public class TagApiResponseBuilder extends AbstractApiResponseBuilder<TagDTO> {

    @Override
    protected String getEntityName() {
        return "tag";
    }
}
