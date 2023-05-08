package com.fashionlike.proyecto_fashion_like.infra.persistence.mapper;

import org.springframework.stereotype.Component;

@Component
public interface MapperPersistence<E, D> {

    D toDomain(E entity);

    E toEntity(D domain);

}
