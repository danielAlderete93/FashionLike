package com.fashionlike.proyecto_fashion_like.app.controller;

import com.fashionlike.proyecto_fashion_like.app.usecase.dto.response.ApiResponse;
import com.fashionlike.proyecto_fashion_like.app.usecase.dto.response.StatusResponse;
import com.fashionlike.proyecto_fashion_like.domain.exceptions.DomainException;
import com.fashionlike.proyecto_fashion_like.domain.usecase.CRUDUseCase;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class BaseCRUDController<T> {
    protected final CRUDUseCase<T> useCase;


    @GetMapping("/{id}")
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<T>> getByID(@PathVariable Integer id) {
        ApiResponse<T> apiResponse;

        T t = useCase.getById(id);
        if (t == null) {
            apiResponse = ApiResponse.error(StatusResponse.notFound("Fail. Not exists"));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
        }
        apiResponse = ApiResponse.success(t, StatusResponse.found("Success found!"));
        return ResponseEntity.ok(apiResponse);


    }

    @GetMapping("/all")
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<List<T>>> getAll() {
        ApiResponse<List<T>> apiResponse;
        List<T> t = useCase.getAll();
        apiResponse = ApiResponse.success(t, StatusResponse.found("Success found"));
        return ResponseEntity.ok(apiResponse);
    }


    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<T>> create(@RequestBody T t) {
        T createdT;
        URI location;
        ApiResponse<T> apiResponse;
        try {
            Integer id = useCase.create(t);
            createdT = useCase.getById(id);

            location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(id)
                    .toUri();

            apiResponse = ApiResponse.success(createdT, StatusResponse.created("Success created"));
            return ResponseEntity.created(location).body(apiResponse);
        } catch (DomainException e) {
            apiResponse = ApiResponse.error(StatusResponse.notCreated(e.getMessage()));
            return ResponseEntity.badRequest().body(apiResponse);
        }
    }

    @PutMapping(value = "/edit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<T>> update(@PathVariable Integer id, @RequestBody T t) {
        T tUpdated;
        ApiResponse<T> apiResponse;
        try {

            useCase.update(id, t);
            tUpdated = useCase.getById(id);
            apiResponse = ApiResponse.success(tUpdated, StatusResponse.updated("Success updated!"));
            return ResponseEntity.ok(apiResponse);

        } catch (DomainException e) {
            apiResponse = ApiResponse.error(StatusResponse.notUpdated(e.getMessage()));
            return ResponseEntity.badRequest().body(apiResponse);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApiResponse<T>> delete(@PathVariable Integer id) {
        ApiResponse<T> apiResponse;
        T t = useCase.getById(id);
        boolean isDeleted = useCase.deleteById(id);

        if (!isDeleted) {
            apiResponse = ApiResponse.error(StatusResponse.deleted("Failed delete!"));
            return ResponseEntity.ok(apiResponse);
        }

        apiResponse = ApiResponse.success(t, StatusResponse.deleted("Success delete!"));
        return ResponseEntity.ok(apiResponse);
    }


}