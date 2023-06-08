package com.fashionlike.proyecto_fashion_like.app.usecase.post;

import com.fashionlike.proyecto_fashion_like.app.usecase.post.dto.PostDTO;
import com.fashionlike.proyecto_fashion_like.app.usecase.post.dto.PostInfoDTO;
import com.fashionlike.proyecto_fashion_like.domain.model.Post;
import com.fashionlike.proyecto_fashion_like.domain.port.service.PostService;
import com.fashionlike.proyecto_fashion_like.domain.usecase.CRUDUseCase;
import com.fashionlike.proyecto_fashion_like.domain.usecase.PostUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PostUseCaseImpl implements PostUseCase {
    private PostService postService;
    private CRUDUseCase<PostDTO> postDTOCRUDUseCase;

    @Override
    public PostInfoDTO deactivate(Integer idPost) {
        Post post = postService.getById(idPost);
        PostInfoDTO infoDTO;

        if (post == null) {
            return null;
        }

        post.setIsActive(false);
        postService.update(idPost, post);

        infoDTO = PostInfoDTO.builder()
                .id(idPost)
                .title(post.getTitle())
                .isActive(false)
                .build();

        return infoDTO;
    }

    @Override
    public PostInfoDTO activate(Integer idPost) {
        Post post = postService.getById(idPost);
        PostInfoDTO infoDTO;
        if (post == null) {
            return null;
        }

        post.setIsActive(true);
        postService.update(idPost, post);

        infoDTO = PostInfoDTO.builder()
                .id(idPost)
                .title(post.getTitle())
                .isActive(true)
                .build();

        return infoDTO;
    }

    @Override
    public PostDTO addView(Integer idPost) {
        Post post = postService.getById(idPost);
        if (post != null) {
            post.addView();
            return postDTOCRUDUseCase.getById(idPost);
        }

        return null;
    }

}
