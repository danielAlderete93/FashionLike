package com.fashionlike.proyecto_fashion_like.app.usecase.tag.crud;

import com.fashionlike.proyecto_fashion_like.app.usecase.converter.ConverterDTO;
import com.fashionlike.proyecto_fashion_like.app.usecase.tag.dto.TagDTO;
import com.fashionlike.proyecto_fashion_like.app.usecase.crud.BaseCRUDUseCase;
import com.fashionlike.proyecto_fashion_like.domain.model.Tag;
import com.fashionlike.proyecto_fashion_like.domain.port.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TagBaseCRUDUseCaseImpl extends BaseCRUDUseCase<Tag, TagDTO> {

    @Autowired
    public TagBaseCRUDUseCaseImpl(TagService service, ConverterDTO<Tag, TagDTO> converter) {
        super(service, converter);
    }

}
