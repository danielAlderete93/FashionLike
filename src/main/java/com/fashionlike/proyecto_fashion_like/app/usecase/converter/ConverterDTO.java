package com.fashionlike.proyecto_fashion_like.app.usecase.converter;

public interface ConverterDTO<D, T> {
    D toDomain(T dto);

    T toDTO(D domain);


}
