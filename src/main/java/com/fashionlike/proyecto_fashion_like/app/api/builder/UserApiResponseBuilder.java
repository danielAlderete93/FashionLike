package com.fashionlike.proyecto_fashion_like.app.api.builder;

import com.fashionlike.proyecto_fashion_like.app.usecase.user.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserApiResponseBuilder extends AbstractApiResponseBuilder<UserDTO> {

    @Override
    protected String getEntityName() {
        return "user";
    }
}

