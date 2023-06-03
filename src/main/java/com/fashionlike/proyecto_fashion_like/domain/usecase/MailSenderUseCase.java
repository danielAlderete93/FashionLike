package com.fashionlike.proyecto_fashion_like.domain.usecase;

import com.fashionlike.proyecto_fashion_like.app.dto.UserDTO;

public interface MailSenderUseCase {

    void sendValidationRegister(UserDTO user);
}
