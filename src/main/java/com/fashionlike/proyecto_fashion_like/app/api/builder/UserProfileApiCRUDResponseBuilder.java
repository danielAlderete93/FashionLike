package com.fashionlike.proyecto_fashion_like.app.api.builder;

import com.fashionlike.proyecto_fashion_like.app.api.builder.crud.AbstractApiCRUDResponseBuilder;
import com.fashionlike.proyecto_fashion_like.app.usecase.user.dto.UserProfileDTO;
import org.springframework.stereotype.Component;

@Component
public class UserProfileApiCRUDResponseBuilder extends AbstractApiCRUDResponseBuilder<UserProfileDTO> {
    @Override
    protected String getEntityName() {
        return "user profile";
    }
}
