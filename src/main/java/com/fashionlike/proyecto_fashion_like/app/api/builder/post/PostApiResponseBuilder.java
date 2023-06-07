package com.fashionlike.proyecto_fashion_like.app.api.builder.post;

import com.fashionlike.proyecto_fashion_like.app.usecase.dto.response.ApiResponse;
import com.fashionlike.proyecto_fashion_like.app.usecase.post.dto.PostInfoDTO;
import org.springframework.http.ResponseEntity;

public interface PostApiResponseBuilder {

    ResponseEntity<ApiResponse<PostInfoDTO>> activePostSuccessResponse(PostInfoDTO postInfoDTO);

    ResponseEntity<ApiResponse<PostInfoDTO>> activePostErrorResponse();

    ResponseEntity<ApiResponse<PostInfoDTO>> deactivePostSuccessResponse(PostInfoDTO postInfoDTO);


    ResponseEntity<ApiResponse<PostInfoDTO>> deactivePostErrorResponse();


}
