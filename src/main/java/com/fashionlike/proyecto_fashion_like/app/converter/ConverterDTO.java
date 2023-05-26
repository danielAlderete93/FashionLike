package com.fashionlike.proyecto_fashion_like.app.converter;

public interface ConverterDTO<D, T> {
    D toDomain(T dto);

    T toDTO(D domain);


}
