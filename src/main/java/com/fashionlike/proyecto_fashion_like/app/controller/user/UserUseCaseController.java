package com.fashionlike.proyecto_fashion_like.app.controller.user;

import com.fashionlike.proyecto_fashion_like.app.api.builder.crud.ApiCRUDResponseBuilder;
import com.fashionlike.proyecto_fashion_like.app.usecase.dto.response.ApiResponse;
import com.fashionlike.proyecto_fashion_like.app.usecase.dto.response.StatusResponse;
import com.fashionlike.proyecto_fashion_like.app.usecase.post.dto.PostInfoDTO;
import com.fashionlike.proyecto_fashion_like.app.usecase.user.dto.UserProfileDTO;
import com.fashionlike.proyecto_fashion_like.domain.usecase.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@AllArgsConstructor
@RestController
@RequestMapping("api/private/user/")
@PreAuthorize("hasAnyRole('ROLE_USER','ROLER_MODERATOR','ROLE_ADMIN') and isAuthenticated()")
public class UserUseCaseController {
    public final UserUseCase useCase;
    public final ApiCRUDResponseBuilder<UserProfileDTO> apiCRUDResponseBuilder;


    @GetMapping("profile")
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<UserProfileDTO>> getByProfile(Principal principal) {
        try {
            String username = principal.getName();
            UserProfileDTO dto = useCase.getProfile(username);
            if (dto == null) {
                return apiCRUDResponseBuilder.notFoundSuccessResponse();
            }
            return apiCRUDResponseBuilder.foundSuccessResponse(dto);

        } catch (Exception e) {
            e.printStackTrace();
            return apiCRUDResponseBuilder.errorServerResponse(e.getMessage());
        }
    }

    @PutMapping("{idUser}/deactive")
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<PostInfoDTO>> deactivePost(@PathVariable Integer idUser) {
        UserProfileDTO profileDTO;
        ApiResponse<UserProfileDTO> apiResponse;

        try {
            /*TODO: Deactive/Active -> ApiResponse */
            profileDTO = postUseCase.deactive(idPost);

            if (infoDTO == null) {
                return postApiResponseBuilder.deactivePostErrorResponse();
            }
            return postApiResponseBuilder.deactivePostSuccessResponse(infoDTO);


        } catch (Exception e) {
            apiResponse = ApiResponse.error(StatusResponse.errorServer(e.getMessage()));

            return ResponseEntity.internalServerError().body(apiResponse);
        }
    }

    @PutMapping("{idUser}/active")
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<PostInfoDTO>> activePost(@PathVariable Integer idUser) {
        PostInfoDTO infoDTO;
        ApiResponse<UserProfileDTO> apiResponse;

        try {
            /*TODO: Deactive/Active -> ApiResponse */
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
