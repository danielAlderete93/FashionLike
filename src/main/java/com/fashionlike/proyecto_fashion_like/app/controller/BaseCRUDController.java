package com.fashionlike.proyecto_fashion_like.app.controller;

import com.fashionlike.proyecto_fashion_like.app.api.builder.crud.ApiCRUDResponseBuilder;
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
public abstract class BaseCRUDController<T> {
    protected final CRUDUseCase<T> useCase;
    protected final ApiCRUDResponseBuilder<T> apiCRUDResponseBuilder;


    @GetMapping("{id}")
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<T>> getByID(@PathVariable Integer id) {
        try {
            T t = useCase.getById(id);
            if (t == null) {
                return apiCRUDResponseBuilder.notFoundSuccessResponse();
            }
            return apiCRUDResponseBuilder.foundSuccessResponse(t);

        } catch (Exception e) {
            e.printStackTrace();
            return apiCRUDResponseBuilder.errorServerResponse(e.getMessage());
        }
    }

    @GetMapping("/all")
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<List<T>>> getAll() {
        try {
            List<T> t = useCase.getAll();
            if (t.isEmpty()) {
                return apiCRUDResponseBuilder.foundListSuccessResponse(new ArrayList<>());
            }
            return apiCRUDResponseBuilder.foundListSuccessResponse(t);

        } catch (Exception e) {
            e.printStackTrace();
            return apiCRUDResponseBuilder.errorServerListResponse(e.getMessage());
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

            return apiCRUDResponseBuilder.createSuccessResponse(location, createdT);
        } catch (DomainException e) {
            return apiCRUDResponseBuilder.createErrorResponse(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return apiCRUDResponseBuilder.errorServerResponse(e.getMessage());
        }
    }

    @PutMapping(value = "/edit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<T>> update(@PathVariable Integer id, @RequestBody T t) {
        T tUpdated;
        try {

            useCase.update(id, t);
            tUpdated = useCase.getById(id);
            return apiCRUDResponseBuilder.updateSuccessResponse(tUpdated);

        } catch (DomainException e) {
            return apiCRUDResponseBuilder.updateErrorResponse(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return apiCRUDResponseBuilder.errorServerResponse(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<T>> delete(@PathVariable Integer id) {
        try {
            T t = useCase.getById(id);
            useCase.deleteById(id);

            return apiCRUDResponseBuilder.deleteSuccessResponse(t);

        } catch (Exception e) {
            e.printStackTrace();
            return apiCRUDResponseBuilder.errorServerResponse(e.getMessage());
        }
    }

}