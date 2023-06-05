package com.fashionlike.proyecto_fashion_like.domain.usecase;

import com.fashionlike.proyecto_fashion_like.app.usecase.user.dto.UserProfileDTO;

public interface UserUseCase {

    UserProfileDTO getProfile(String username);

}