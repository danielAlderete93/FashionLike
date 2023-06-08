package com.fashionlike.proyecto_fashion_like.app.controller.post;

import com.fashionlike.proyecto_fashion_like.app.usecase.dto.response.ApiResponse;
import com.fashionlike.proyecto_fashion_like.app.usecase.dto.response.StatusResponse;
import com.fashionlike.proyecto_fashion_like.app.usecase.post.dto.PostDTO;
import com.fashionlike.proyecto_fashion_like.app.usecase.post.dto.PostInfoDTO;
import com.fashionlike.proyecto_fashion_like.domain.usecase.PostUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/private/post/")
public class PostUseCaseController {

    private PostUseCase postUseCase;


    @PutMapping("{idPost}/deactivate")
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<PostInfoDTO>> deactivatePost(@PathVariable Integer idPost) {
        PostInfoDTO infoDTO;
        ApiResponse<PostInfoDTO> apiResponse;

        try {
            infoDTO = postUseCase.deactivate(idPost);

            if (infoDTO == null) {
                apiResponse = ApiResponse.error(StatusResponse.notUpdated("Deactivate post"));
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
            }

            apiResponse = ApiResponse.success(infoDTO, StatusResponse.found("Deactivate post"));
            return ResponseEntity.ok(apiResponse);


        } catch (Exception e) {
            apiResponse = ApiResponse.error(StatusResponse.errorServer(e.getMessage()));
            return ResponseEntity.internalServerError().body(apiResponse);
        }
    }

    @PutMapping("{idPost}/activate")
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<PostInfoDTO>> activatePost(@PathVariable Integer idPost) {
        PostInfoDTO infoDTO;
        ApiResponse<PostInfoDTO> apiResponse;

        try {
            infoDTO = postUseCase.activate(idPost);

            if (infoDTO == null) {
                apiResponse = ApiResponse.error(StatusResponse.notUpdated("Activate post"));
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
            }

            apiResponse = ApiResponse.success(infoDTO, StatusResponse.found("Activate post"));
            return ResponseEntity.ok(apiResponse);


        } catch (Exception e) {
            apiResponse = ApiResponse.error(StatusResponse.errorServer(e.getMessage()));
            return ResponseEntity.internalServerError().body(apiResponse);
        }
    }

    @GetMapping("{idPost}/view")
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<PostDTO>> view(@PathVariable Integer idPost) {
        PostDTO postViewed;
        ApiResponse<PostDTO> apiResponse;

        try {
            postViewed = postUseCase.addView(idPost);

            if (postViewed == null) {
                apiResponse = ApiResponse.error(StatusResponse.notFound("Fail. Not exists"));
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
            }
            apiResponse = ApiResponse.success(postViewed, StatusResponse.found("Success found!"));
            return ResponseEntity.ok(apiResponse);


        } catch (Exception e) {
            apiResponse = ApiResponse.error(StatusResponse.errorServer(e.getMessage()));
            return ResponseEntity.internalServerError().body(apiResponse);
        }
    }



}
