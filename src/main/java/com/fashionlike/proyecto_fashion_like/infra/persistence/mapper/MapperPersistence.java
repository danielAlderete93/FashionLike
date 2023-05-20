package com.fashionlike.proyecto_fashion_like.infra.persistence.mapper;

import java.util.Optional;

public interface MapperPersistence<E, D> {

    Optional<D> toDomain(E entity);

    Optional<E> toEntity(D domain);

}
