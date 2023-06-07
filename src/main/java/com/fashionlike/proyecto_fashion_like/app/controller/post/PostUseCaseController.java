package com.fashionlike.proyecto_fashion_like.app.controller.post;

import com.fashionlike.proyecto_fashion_like.app.api.builder.post.PostApiResponseBuilder;
import com.fashionlike.proyecto_fashion_like.app.usecase.dto.response.ApiResponse;
import com.fashionlike.proyecto_fashion_like.app.usecase.dto.response.StatusResponse;
import com.fashionlike.proyecto_fashion_like.app.usecase.post.dto.PostInfoDTO;
import com.fashionlike.proyecto_fashion_like.domain.usecase.PostUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/private/post/")
public class PostUseCaseController {

    private PostUseCase postUseCase;
    private PostApiResponseBuilder postApiResponseBuilder;


    @PutMapping("{idPost}/deactive")
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<PostInfoDTO>> deactivePost(@PathVariable Integer idPost) {
        PostInfoDTO infoDTO;
        ApiResponse<PostInfoDTO> apiResponse;

        try {
            infoDTO = postUseCase.deactive(idPost);

            if (infoDTO == null) {
                return postApiResponseBuilder.deactivePostErrorResponse();
            }
            return postApiResponseBuilder.deactivePostSuccessResponse(infoDTO);


        } catch (Exception e) {
            apiResponse = ApiResponse.error(StatusResponse.errorServer(e.getMessage()));

            return ResponseEntity.internalServerError().body(apiResponse);
        }
    }

    @PutMapping("{idPost}/active")
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<PostInfoDTO>> activePost(@PathVariable Integer idPost) {
        PostInfoDTO infoDTO;
        ApiResponse<PostInfoDTO> apiResponse;

        try {
            infoDTO = postUseCase.active(idPost);

            if (infoDTO == null) {
                return postApiResponseBuilder.activePostErrorResponse();
            }
            return postApiResponseBuilder.activePostSuccessResponse(infoDTO);


        } catch (Exception e) {
            apiResponse = ApiResponse.error(StatusResponse.errorServer(e.getMessage()));

            return ResponseEntity.internalServerError().body(apiResponse);
        }
    }

}
