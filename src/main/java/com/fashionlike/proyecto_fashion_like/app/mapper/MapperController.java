package com.fashionlike.proyecto_fashion_like.app.mapper;

public interface MapperController<D, T> {
    D toDomain(T dto);

    T toDTO(D domain);


}
