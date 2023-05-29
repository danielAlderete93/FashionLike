package com.fashionlike.proyecto_fashion_like.app.controller;

import com.fashionlike.proyecto_fashion_like.app.api.ApiResponseBuilder;
import com.fashionlike.proyecto_fashion_like.app.dto.TagDTO;
import com.fashionlike.proyecto_fashion_like.domain.usecase.TagUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/private/tag/")
public class TagController extends BaseController<TagDTO> {

    @Autowired
    protected TagController(TagUseCase useCase, ApiResponseBuilder<TagDTO> apiResponseBuilder) {
        super(useCase, apiResponseBuilder);
    }

}
