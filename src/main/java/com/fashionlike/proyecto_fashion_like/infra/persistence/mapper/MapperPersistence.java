package com.fashionlike.proyecto_fashion_like.infra.persistence.mapper;

public interface MapperPersistence<E, D> {

    D toDomain(E entity);

    E toEntity(D domain);

}
