package com.fashionlike.proyecto_fashion_like.app.factories;

import com.fashionlike.proyecto_fashion_like.app.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserApiResponseBuilder extends AbstractApiResponseBuilder<UserDTO> {

    @Override
    protected String getEntityName() {
        return "user";
    }
}

