package com.fashionlike.proyecto_fashion_like.app.controller;

import com.fashionlike.proyecto_fashion_like.app.api.ApiResponseBuilder;
import com.fashionlike.proyecto_fashion_like.app.usecase.dto.response.ApiResponse;
import com.fashionlike.proyecto_fashion_like.domain.exceptions.DomainException;
import com.fashionlike.proyecto_fashion_like.domain.usecase.CRUDUseCase;
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
public abstract class BaseCRUDController<T> {
    protected final CRUDUseCase<T> useCase;
    protected final ApiResponseBuilder<T> apiResponseBuilder;


    @GetMapping("{id}")
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<T>> getByID(@PathVariable Integer id) {
        try {
            T t = useCase.getById(id);
            if (t == null) {
                return apiResponseBuilder.notFoundSuccessResponse();
            }
            return apiResponseBuilder.foundSuccessResponse(t);

        } catch (Exception e) {
            e.printStackTrace();
            return apiResponseBuilder.errorServerResponse(e.getMessage());
        }
    }

    @GetMapping("/all")
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<List<T>>> getAll() {
        try {
            List<T> t = useCase.getAll();
            if (t.isEmpty()) {
                return apiResponseBuilder.foundListSuccessResponse(new ArrayList<>());
            }
            return apiResponseBuilder.foundListSuccessResponse(t);

        } catch (Exception e) {
            e.printStackTrace();
            return apiResponseBuilder.errorServerListResponse(e.getMessage());
        }
    }


    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<T>> create(@RequestBody T t) {
        T createdT;
        URI location;
        try {
            Integer id = useCase.create(t);
            createdT = useCase.getById(id);

            location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(id)
                    .toUri();

            return apiResponseBuilder.createSuccessResponse(location, createdT);
        } catch (DomainException e) {
            return apiResponseBuilder.createErrorResponse(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return apiResponseBuilder.errorServerResponse(e.getMessage());
        }
    }

    @PutMapping(value = "/edit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<T>> update(@PathVariable Integer id, @RequestBody T t) {
        T tUpdated;
        try {

            useCase.update(id, t);
            tUpdated = useCase.getById(id);
            return apiResponseBuilder.updateSuccessResponse(tUpdated);

        } catch (DomainException e) {
            return apiResponseBuilder.updateErrorResponse(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return apiResponseBuilder.errorServerResponse(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<T>> delete(@PathVariable Integer id) {
        try {
            T t = useCase.getById(id);
            useCase.deleteById(id);

            return apiResponseBuilder.deleteSuccessResponse(t);

        } catch (Exception e) {
            e.printStackTrace();
            return apiResponseBuilder.errorServerResponse(e.getMessage());
        }
    }

}