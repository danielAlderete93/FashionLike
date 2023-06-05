package com.fashionlike.proyecto_fashion_like.app.usecase.post.crud;

import com.fashionlike.proyecto_fashion_like.app.usecase.converter.ConverterDTO;
import com.fashionlike.proyecto_fashion_like.app.usecase.post.dto.PostDTO;
import com.fashionlike.proyecto_fashion_like.app.usecase.crud.BaseCRUDUseCase;
import com.fashionlike.proyecto_fashion_like.domain.model.Post;
import com.fashionlike.proyecto_fashion_like.domain.port.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostCRUDUseCase extends BaseCRUDUseCase<Post, PostDTO> {
    @Autowired
    public PostCRUDUseCase(PostService service, ConverterDTO<Post, PostDTO> converter) {
        super(service, converter);
    }
}
