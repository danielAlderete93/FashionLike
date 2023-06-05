package com.fashionlike.proyecto_fashion_like.app.usecase.post.converter;

import com.fashionlike.proyecto_fashion_like.app.usecase.converter.ConverterDTO;
import com.fashionlike.proyecto_fashion_like.app.usecase.post.dto.PostSummaryDTO;
import com.fashionlike.proyecto_fashion_like.domain.model.Post;
import org.springframework.stereotype.Service;

@Service
public class PostSummaryConverterDTO implements ConverterDTO<Post, PostSummaryDTO> {

    @Override
    public Post toDomain(PostSummaryDTO dto) {
        return null;
    }

    @Override
    public PostSummaryDTO toDTO(Post domain) {
        return PostSummaryDTO.builder()
                .id(domain.getId())
                .description(domain.getDescription())
                .views(domain.getViews())
                .title(domain.getTitle())
                .isActive(domain.getIsActive())
                .date(domain.getDate())
                .img(domain.getImg())
                .build();
    }
}
