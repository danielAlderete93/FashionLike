package com.fashionlike.proyecto_fashion_like.app.api.builder;

import com.fashionlike.proyecto_fashion_like.app.usecase.user.dto.UserProfileDTO;
import org.springframework.stereotype.Component;

@Component
public class UserProfileApiResponseBuilder extends AbstractApiResponseBuilder<UserProfileDTO> {
    @Override
    protected String getEntityName() {
        return "user profile";
    }
}
