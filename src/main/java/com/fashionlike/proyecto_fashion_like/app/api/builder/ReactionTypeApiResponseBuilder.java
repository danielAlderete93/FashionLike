package com.fashionlike.proyecto_fashion_like.app.api.builder;

import com.fashionlike.proyecto_fashion_like.app.dto.ReactionTypeDTO;
import org.springframework.stereotype.Component;

@Component
public class ReactionTypeApiResponseBuilder extends AbstractApiResponseBuilder<ReactionTypeDTO> {
    @Override
    protected String getEntityName() {
        return "reaction type";
    }
}
