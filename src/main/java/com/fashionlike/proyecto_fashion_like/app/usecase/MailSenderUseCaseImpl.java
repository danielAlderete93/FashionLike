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
    public void sendValidationRegister(UserDTO user) {

        mailSenderService.sendEmail(user.getMail(), SUBJECT_MESSAGE, "Este es el mail");
    }
}
