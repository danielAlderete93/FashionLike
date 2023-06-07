package com.fashionlike.proyecto_fashion_like.app.api.builder;

import com.fashionlike.proyecto_fashion_like.app.api.builder.crud.AbstractApiCRUDResponseBuilder;
import com.fashionlike.proyecto_fashion_like.app.usecase.reactiontype.dto.ReactionTypeDTO;
import org.springframework.stereotype.Component;

@Component
public class ReactionTypeApiCRUDResponseBuilder extends AbstractApiCRUDResponseBuilder<ReactionTypeDTO> {
    @Override
    protected String getEntityName() {
        return "reaction type";
    }
}
