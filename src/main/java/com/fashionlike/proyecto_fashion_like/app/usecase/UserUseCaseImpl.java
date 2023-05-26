package com.fashionlike.proyecto_fashion_like.app.usecase;

import com.fashionlike.proyecto_fashion_like.app.converter.ConverterDTO;
import com.fashionlike.proyecto_fashion_like.app.dto.UserDTO;
import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.port.service.UserService;
import com.fashionlike.proyecto_fashion_like.domain.usecase.UserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class UserUseCaseImpl extends BaseUseCaseImpl<User, UserDTO> implements UserUseCase {

    @Autowired
    public UserUseCaseImpl(UserService service, ConverterDTO<User, UserDTO> converter) {
        super(service, converter);
    }
}
