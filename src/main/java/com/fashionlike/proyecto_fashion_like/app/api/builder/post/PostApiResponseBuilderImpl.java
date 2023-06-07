package com.fashionlike.proyecto_fashion_like.app.api.builder.post;

import com.fashionlike.proyecto_fashion_like.app.usecase.dto.response.ApiResponse;
import com.fashionlike.proyecto_fashion_like.app.usecase.dto.response.StatusResponse;
import com.fashionlike.proyecto_fashion_like.app.usecase.post.dto.PostInfoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PostApiResponseBuilderImpl extends PostApiCRUDResponseBuilder implements PostApiResponseBuilder {
    @Override
    public ResponseEntity<ApiResponse<PostInfoDTO>> deactivePostSuccessResponse(PostInfoDTO infoDTO) {
        ApiResponse<PostInfoDTO> apiResponse = ApiResponse.success(infoDTO, StatusResponse.updated("Post is deactive"));
        return ResponseEntity.ok(apiResponse);
    }

    @Override
    public ResponseEntity<ApiResponse<PostInfoDTO>> activePostSuccessResponse(PostInfoDTO infoDTO) {
        ApiResponse<PostInfoDTO> apiResponse = ApiResponse.success(infoDTO, StatusResponse.updated("Post is active"));
        return ResponseEntity.ok(apiResponse);
    }

    @Override
    public ResponseEntity<ApiResponse<PostInfoDTO>> deactivePostErrorResponse() {
        ApiResponse<PostInfoDTO> apiResponse = ApiResponse.error(StatusResponse.notUpdated("Post cannot deactive"));
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @Override
    public ResponseEntity<ApiResponse<PostInfoDTO>> activePostErrorResponse() {
        ApiResponse<PostInfoDTO> apiResponse = ApiResponse.error(StatusResponse.notUpdated("Post cannot active"));
        return ResponseEntity.badRequest().body(apiResponse);

    }


}
