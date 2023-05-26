package com.fashionlike.proyecto_fashion_like.app.controller;

import com.fashionlike.proyecto_fashion_like.app.api.ApiResponseBuilder;
import com.fashionlike.proyecto_fashion_like.app.dto.ReactionTypeDTO;
import com.fashionlike.proyecto_fashion_like.domain.usecase.ReactionTypeUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/reaction/")

public class ReactionTypeController extends BaseController<ReactionTypeDTO> {

    @Autowired
    public ReactionTypeController(ReactionTypeUseCase useCase, ApiResponseBuilder<ReactionTypeDTO> apiResponseBuilder) {
        super(useCase, apiResponseBuilder);
    }
}
