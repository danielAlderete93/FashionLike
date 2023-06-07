package com.fashionlike.proyecto_fashion_like.app.api.builder;

import com.fashionlike.proyecto_fashion_like.app.api.builder.crud.AbstractApiCRUDResponseBuilder;
import com.fashionlike.proyecto_fashion_like.app.usecase.tag.dto.TagDTO;
import org.springframework.stereotype.Component;

@Component
public class TagApiCRUDResponseBuilder extends AbstractApiCRUDResponseBuilder<TagDTO> {

    @Override
    protected String getEntityName() {
        return "tag";
    }
}
