package com.fashionlike.proyecto_fashion_like.app.controller;

import com.fashionlike.proyecto_fashion_like.app.api.ApiResponseBuilder;
import com.fashionlike.proyecto_fashion_like.app.dto.PostDTO;
import com.fashionlike.proyecto_fashion_like.domain.usecase.PostUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/private/post/")
public class PostController extends BaseController<PostDTO> {

    @Autowired
    public PostController(PostUseCase useCase, ApiResponseBuilder<PostDTO> apiResponseBuilder) {
        super(useCase, apiResponseBuilder);
    }


}
