package com.fashionlike.proyecto_fashion_like.app.usecase;

import com.fashionlike.proyecto_fashion_like.app.converter.ConverterDTO;
import com.fashionlike.proyecto_fashion_like.app.dto.PostDTO;
import com.fashionlike.proyecto_fashion_like.domain.model.Post;
import com.fashionlike.proyecto_fashion_like.domain.port.service.PostService;
import com.fashionlike.proyecto_fashion_like.domain.usecase.PostUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostUseCaseImpl extends BaseUseCaseImpl<Post, PostDTO> implements PostUseCase {
    @Autowired
    public PostUseCaseImpl(PostService service, ConverterDTO<Post, PostDTO> converter) {
        super(service, converter);
    }
}
