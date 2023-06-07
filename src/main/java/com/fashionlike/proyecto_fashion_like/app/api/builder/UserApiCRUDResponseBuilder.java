package com.fashionlike.proyecto_fashion_like.app.api.builder;

import com.fashionlike.proyecto_fashion_like.app.api.builder.crud.AbstractApiCRUDResponseBuilder;
import com.fashionlike.proyecto_fashion_like.app.usecase.user.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserApiCRUDResponseBuilder extends AbstractApiCRUDResponseBuilder<UserDTO> {

    @Override
    protected String getEntityName() {
        return "user";
    }
}

