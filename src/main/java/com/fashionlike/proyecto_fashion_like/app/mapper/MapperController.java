package com.fashionlike.proyecto_fashion_like.app.mapper;

import org.springframework.stereotype.Component;

@Component
public interface MapperController<T, D> {
    D toDomain(T dto);

    T toDTO(D domain);

}
