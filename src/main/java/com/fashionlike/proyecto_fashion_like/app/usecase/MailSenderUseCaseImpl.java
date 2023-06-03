package com.fashionlike.proyecto_fashion_like.app.usecase;

import com.fashionlike.proyecto_fashion_like.app.dto.UserDTO;
import com.fashionlike.proyecto_fashion_like.domain.port.service.MailSenderService;
import com.fashionlike.proyecto_fashion_like.domain.usecase.MailSenderUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class MailSenderUseCaseImpl implements MailSenderUseCase {
    private static final String SUBJECT_MESSAGE = "Activate account";
    private final MailSenderService mailSenderService;


    @Override
    public void sendValidationRegister(UserDTO user, String token) {
        mailSenderService.sendEmail(user.getMail(), SUBJECT_MESSAGE, getBody(token));
    }

    private String getBody(String token) {
        return "<h1> Bienvenido a Fashion Like</h1>" +
                "<p>Para validar tu cuenta debes hacer click en el siguiente link:</p>" +
                "<a href='http://localhost:8080/api/public/auth/validate?token=" +
                token +
                "'>valida cuenta</a>";
    }
}
