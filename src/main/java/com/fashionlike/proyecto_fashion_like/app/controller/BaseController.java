package com.fashionlike.proyecto_fashion_like.app.controller;

import com.fashionlike.proyecto_fashion_like.app.api.ApiResponseBuilder;
import com.fashionlike.proyecto_fashion_like.app.dto.response.ApiResponse;
import com.fashionlike.proyecto_fashion_like.domain.exceptions.DomainException;
import com.fashionlike.proyecto_fashion_like.domain.usecase.BaseUseCase;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN') and isAuthenticated()")
public abstract class BaseController<DTO> {
    private final BaseUseCase<DTO> useCase;
    private final ApiResponseBuilder<DTO> apiResponseBuilder;


    @GetMapping("{id}")
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<DTO>> getByID(@PathVariable Integer id) {
        try {
            DTO dto = useCase.getById(id);
            if (dto == null) {
                return apiResponseBuilder.notFoundSuccessResponse();
            }
            return apiResponseBuilder.foundSuccessResponse(dto);

        } catch (Exception e) {
            e.printStackTrace();
            return apiResponseBuilder.errorServerResponse(e.getMessage());
        }
    }

    @GetMapping("/all")
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<List<DTO>>> getAll() {
        try {
            List<DTO> dto = useCase.getAll();
            if (dto.isEmpty()) {
                return apiResponseBuilder.foundListSuccessResponse(new ArrayList<>());
            }
            return apiResponseBuilder.foundListSuccessResponse(dto);

        } catch (Exception e) {
            e.printStackTrace();
            return apiResponseBuilder.errorServerListResponse(e.getMessage());
        }
    }


    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<DTO>> create(@RequestBody DTO dto) {
        DTO createdDTO;
        URI location;
        try {
            Integer id = useCase.create(dto);
            createdDTO = useCase.getById(id);

            location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(id)
                    .toUri();

            return apiResponseBuilder.createSuccessResponse(location, createdDTO);
        } catch (DomainException e) {
            return apiResponseBuilder.createErrorResponse(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return apiResponseBuilder.errorServerResponse(e.getMessage());
        }
    }

    @PutMapping(value = "/edit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<DTO>> update(@PathVariable Integer id, @RequestBody DTO dto) {
        DTO dtoUpdated;
        try {

            useCase.update(id, dto);
            dtoUpdated = useCase.getById(id);
            return apiResponseBuilder.updateSuccessResponse(dtoUpdated);

        } catch (DomainException e) {
            return apiResponseBuilder.updateErrorResponse(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return apiResponseBuilder.errorServerResponse(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<DTO>> delete(@PathVariable Integer id) {
        try {
            DTO dto = useCase.getById(id);
            useCase.deleteById(id);

            return apiResponseBuilder.deleteSuccessResponse(dto);

        } catch (Exception e) {
            e.printStackTrace();
            return apiResponseBuilder.errorServerResponse(e.getMessage());
        }
    }

}