package com.fashionlike.proyecto_fashion_like.app.controller.reactiontype;

import com.fashionlike.proyecto_fashion_like.app.controller.BaseCRUDController;
import com.fashionlike.proyecto_fashion_like.app.usecase.reactiontype.dto.ReactionTypeDTO;
import com.fashionlike.proyecto_fashion_like.domain.usecase.CRUDUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/private/reaction/type")

public class ReactionTypeCRUDController extends BaseCRUDController<ReactionTypeDTO> {

    @Autowired
    public ReactionTypeCRUDController(CRUDUseCase<ReactionTypeDTO> useCase) {
        super(useCase);
    }
}
