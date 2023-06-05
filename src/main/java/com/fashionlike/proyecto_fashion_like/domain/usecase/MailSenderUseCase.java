package com.fashionlike.proyecto_fashion_like.domain.usecase;

import com.fashionlike.proyecto_fashion_like.app.usecase.user.dto.UserDTO;

public interface MailSenderUseCase {

    void sendValidationRegister(UserDTO user, String token);
}
