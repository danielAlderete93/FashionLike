package com.fashionlike.proyecto_fashion_like.app.usecase.post;

import com.fashionlike.proyecto_fashion_like.app.usecase.post.dto.PostInfoDTO;
import com.fashionlike.proyecto_fashion_like.domain.model.Post;
import com.fashionlike.proyecto_fashion_like.domain.port.service.PostService;
import com.fashionlike.proyecto_fashion_like.domain.usecase.PostUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PostUseCaseImpl implements PostUseCase {
    private PostService postService;

    @Override
    public PostInfoDTO deactive(Integer idPost) {
        Post post = postService.getById(idPost);
        PostInfoDTO infoDTO;

        if (post == null) {
            return null;
        }

        post.setIsActive(false);
        postService.update(idPost, post);

        infoDTO = PostInfoDTO.builder()
                .id(idPost)
                .isActive(false)
                .build();

        return infoDTO;
    }

    @Override
    public PostInfoDTO active(Integer idPost) {
        Post post = postService.getById(idPost);
        PostInfoDTO infoDTO;
        if (post == null) {
            return null;
        }

        post.setIsActive(true);
        postService.update(idPost, post);

        infoDTO = PostInfoDTO.builder()
                .id(idPost)
                .isActive(true)
                .build();

        return infoDTO;
    }
}
