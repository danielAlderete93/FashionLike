package com.fashionlike.proyecto_fashion_like.app.controller;

import com.fashionlike.proyecto_fashion_like.app.api.ApiResponseBuilder;
import com.fashionlike.proyecto_fashion_like.app.usecase.tag.dto.TagDTO;
import com.fashionlike.proyecto_fashion_like.domain.usecase.CRUDUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/private/tag/")
public class TagCRUDController extends BaseCRUDController<TagDTO> {

    @Autowired
    protected TagCRUDController(CRUDUseCase<TagDTO> useCase, ApiResponseBuilder<TagDTO> apiResponseBuilder) {
        super(useCase, apiResponseBuilder);
    }

}
