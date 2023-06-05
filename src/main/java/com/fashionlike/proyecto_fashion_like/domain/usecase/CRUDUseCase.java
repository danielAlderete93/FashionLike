package com.fashionlike.proyecto_fashion_like.domain.usecase;

import java.util.List;

public interface CRUDUseCase<D> {
    D getById(Integer id);

    List<D> getAll();

    Integer create(D post);

    void update(Integer id, D post);

    Boolean deleteById(Integer id);
}
