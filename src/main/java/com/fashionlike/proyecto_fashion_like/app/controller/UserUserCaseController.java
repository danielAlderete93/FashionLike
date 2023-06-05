package com.fashionlike.proyecto_fashion_like.app.controller;

import com.fashionlike.proyecto_fashion_like.app.api.ApiResponseBuilder;
import com.fashionlike.proyecto_fashion_like.app.usecase.dto.response.ApiResponse;
import com.fashionlike.proyecto_fashion_like.app.usecase.user.dto.UserProfileDTO;
import com.fashionlike.proyecto_fashion_like.domain.usecase.UserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
@RequestMapping("api/private/user/")
@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN') and isAuthenticated()")
public class UserUserCaseController {
    public final UserUseCase useCase;
    public final ApiResponseBuilder<UserProfileDTO> apiResponseBuilder;

    @Autowired
    public UserUserCaseController(UserUseCase useCase, ApiResponseBuilder<UserProfileDTO> apiResponseBuilder) {
        this.useCase = useCase;
        this.apiResponseBuilder = apiResponseBuilder;
    }

    @GetMapping("profile")
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<UserProfileDTO>> getByProfile(Principal principal) {
        try {
            String username = principal.getName();
            UserProfileDTO dto = useCase.getProfile(username);
            if (dto == null) {
                return apiResponseBuilder.notFoundSuccessResponse();
            }
            return apiResponseBuilder.foundSuccessResponse(dto);

        } catch (Exception e) {
            e.printStackTrace();
            return apiResponseBuilder.errorServerResponse(e.getMessage());
        }
    }
}
