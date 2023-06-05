package com.fashionlike.proyecto_fashion_like.app.usecase.reactiontype.crud;

import com.fashionlike.proyecto_fashion_like.app.usecase.converter.ConverterDTO;
import com.fashionlike.proyecto_fashion_like.app.usecase.reactiontype.dto.ReactionTypeDTO;
import com.fashionlike.proyecto_fashion_like.app.usecase.crud.BaseCRUDUseCase;
import com.fashionlike.proyecto_fashion_like.domain.model.ReactionType;
import com.fashionlike.proyecto_fashion_like.domain.port.service.ReactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReactionTypeCRUDUseCase extends BaseCRUDUseCase<ReactionType, ReactionTypeDTO> {
    @Autowired
    protected ReactionTypeCRUDUseCase(ReactionTypeService service, ConverterDTO<ReactionType, ReactionTypeDTO> converter) {
        super(service, converter);
    }
}
