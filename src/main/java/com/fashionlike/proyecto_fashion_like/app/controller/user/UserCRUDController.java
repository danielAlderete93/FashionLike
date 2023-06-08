package com.fashionlike.proyecto_fashion_like.app.controller.user;


import com.fashionlike.proyecto_fashion_like.app.controller.BaseCRUDController;
import com.fashionlike.proyecto_fashion_like.app.usecase.user.dto.UserDTO;
import com.fashionlike.proyecto_fashion_like.domain.usecase.CRUDUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/private/user")
public class UserCRUDController extends BaseCRUDController<UserDTO> {
    @Autowired
    public UserCRUDController(CRUDUseCase<UserDTO> useCase) {
        super(useCase);
    }
}