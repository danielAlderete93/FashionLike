package com.fashionlike.proyecto_fashion_like.app.usecase.user.crud;

import com.fashionlike.proyecto_fashion_like.app.usecase.converter.ConverterDTO;
import com.fashionlike.proyecto_fashion_like.app.usecase.user.dto.UserDTO;
import com.fashionlike.proyecto_fashion_like.app.usecase.crud.BaseCRUDUseCase;
import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.port.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class UserCRUDUseCase extends BaseCRUDUseCase<User, UserDTO> {

    @Autowired
    public UserCRUDUseCase(UserService service, ConverterDTO<User, UserDTO> converter) {
        super(service, converter);
    }

}
