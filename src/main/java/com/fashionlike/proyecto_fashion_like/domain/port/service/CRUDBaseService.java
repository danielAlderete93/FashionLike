package com.fashionlike.proyecto_fashion_like.domain.port.service;

import java.util.List;

public interface CRUDBaseService<T> {
    T getById(Integer id);

    List<T> getAll();

    Integer create(T o);

    void update(Integer id, T o);

    Boolean deleteById(Integer id);
}
