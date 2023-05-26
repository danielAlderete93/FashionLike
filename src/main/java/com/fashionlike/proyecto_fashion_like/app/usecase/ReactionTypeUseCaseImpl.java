package com.fashionlike.proyecto_fashion_like.app.usecase;

import com.fashionlike.proyecto_fashion_like.app.converter.ConverterDTO;
import com.fashionlike.proyecto_fashion_like.app.dto.ReactionTypeDTO;
import com.fashionlike.proyecto_fashion_like.domain.model.ReactionType;
import com.fashionlike.proyecto_fashion_like.domain.port.service.ReactionTypeService;
import com.fashionlike.proyecto_fashion_like.domain.usecase.ReactionTypeUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReactionTypeUseCaseImpl extends BaseUseCaseImpl<ReactionType, ReactionTypeDTO> implements ReactionTypeUseCase {
    @Autowired
    protected ReactionTypeUseCaseImpl(ReactionTypeService service, ConverterDTO<ReactionType, ReactionTypeDTO> converter) {
        super(service, converter);
    }
}
