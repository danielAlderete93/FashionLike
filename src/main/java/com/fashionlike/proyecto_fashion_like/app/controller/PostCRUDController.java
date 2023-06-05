package com.fashionlike.proyecto_fashion_like.app.controller;

import com.fashionlike.proyecto_fashion_like.app.api.ApiResponseBuilder;
import com.fashionlike.proyecto_fashion_like.app.usecase.post.dto.PostDTO;
import com.fashionlike.proyecto_fashion_like.domain.usecase.CRUDUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/private/post/")
public class PostCRUDController extends BaseCRUDController<PostDTO> {

    @Autowired
    public PostCRUDController(CRUDUseCase<PostDTO> useCase, ApiResponseBuilder<PostDTO> apiResponseBuilder) {
        super(useCase, apiResponseBuilder);
    }


}
