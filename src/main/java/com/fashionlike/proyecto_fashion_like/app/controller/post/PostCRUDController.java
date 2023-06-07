package com.fashionlike.proyecto_fashion_like.app.controller.post;

import com.fashionlike.proyecto_fashion_like.app.api.builder.crud.ApiCRUDResponseBuilder;
import com.fashionlike.proyecto_fashion_like.app.controller.BaseCRUDController;
import com.fashionlike.proyecto_fashion_like.app.usecase.post.dto.PostDTO;
import com.fashionlike.proyecto_fashion_like.domain.usecase.CRUDUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/private/post/")
public class PostCRUDController extends BaseCRUDController<PostDTO> {

    @Autowired
    public PostCRUDController(CRUDUseCase<PostDTO> useCase, ApiCRUDResponseBuilder<PostDTO> apiCRUDResponseBuilder) {
        super(useCase, apiCRUDResponseBuilder);
    }


}
