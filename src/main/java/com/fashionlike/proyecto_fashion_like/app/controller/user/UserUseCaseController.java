package com.fashionlike.proyecto_fashion_like.app.controller.user;

import com.fashionlike.proyecto_fashion_like.app.usecase.dto.response.ApiResponse;
import com.fashionlike.proyecto_fashion_like.app.usecase.dto.response.StatusResponse;
import com.fashionlike.proyecto_fashion_like.app.usecase.user.dto.UserInfoDTO;
import com.fashionlike.proyecto_fashion_like.app.usecase.user.dto.UserProfileDTO;
import com.fashionlike.proyecto_fashion_like.domain.usecase.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@AllArgsConstructor
@RestController
@RequestMapping("api/private/user")
@PreAuthorize("hasAnyRole('ROLE_USER','ROLER_MODERATOR','ROLE_ADMIN') and isAuthenticated()")
public class UserUseCaseController {
    public final UserUseCase useCase;


    @GetMapping("/profile")
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<UserProfileDTO>> getByProfile(Principal principal) {
        ApiResponse<UserProfileDTO> apiResponse;
        try {
            String username = principal.getName();
            UserProfileDTO dto = useCase.getProfile(username);

            if (dto == null) {
                apiResponse = ApiResponse.error(StatusResponse.notFound("Failed found."));
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
            }

            apiResponse = ApiResponse.success(dto, StatusResponse.found("Success Found!"));

            return ResponseEntity.ok(apiResponse);

        } catch (Exception e) {
            e.printStackTrace();
            apiResponse = ApiResponse.error(StatusResponse.errorServer(e.getMessage()));
            return ResponseEntity.internalServerError().body(apiResponse);
        }
    }

    @PutMapping("/{idUser}/deactivate")
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<UserInfoDTO>> deactivateUser(@PathVariable Integer idUser) {
        UserInfoDTO infoDTO;
        ApiResponse<UserInfoDTO> apiResponse;

        try {
            infoDTO = useCase.deactivate(idUser);

            if (infoDTO == null) {
                apiResponse = ApiResponse.error(StatusResponse.notUpdated("Deactivate User"));
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
            }

            apiResponse = ApiResponse.success(infoDTO, StatusResponse.found("Deactivate User"));
            return ResponseEntity.ok(apiResponse);


        } catch (Exception e) {
            apiResponse = ApiResponse.error(StatusResponse.errorServer(e.getMessage()));
            return ResponseEntity.internalServerError().body(apiResponse);
        }
    }

    @PutMapping("/{idUser}/activate")
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<UserInfoDTO>> activateUser(@PathVariable Integer idUser) {
        UserInfoDTO infoDTO;
        ApiResponse<UserInfoDTO> apiResponse;

        try {
            infoDTO = useCase.activate(idUser);

            if (infoDTO == null) {
                apiResponse = ApiResponse.error(StatusResponse.notUpdated("Activate User"));
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
            }

            apiResponse = ApiResponse.success(infoDTO, StatusResponse.found("Activate User"));
            return ResponseEntity.ok(apiResponse);


        } catch (Exception e) {
            apiResponse = ApiResponse.error(StatusResponse.errorServer(e.getMessage()));

            return ResponseEntity.internalServerError().body(apiResponse);
        }
    }

}
