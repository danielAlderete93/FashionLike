package com.fashionlike.proyecto_fashion_like.app.usecase.crud;

import com.fashionlike.proyecto_fashion_like.app.usecase.converter.ConverterDTO;
import com.fashionlike.proyecto_fashion_like.domain.port.service.CRUDBaseService;
import com.fashionlike.proyecto_fashion_like.domain.usecase.CRUDUseCase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseCRUDUseCase<D, T> implements CRUDUseCase<T> {
    protected final CRUDBaseService<D> service;

    protected final ConverterDTO<D, T> converter;

    protected BaseCRUDUseCase(CRUDBaseService<D> service, ConverterDTO<D, T> converter) {
        this.service = service;
        this.converter = converter;
    }

    @Override
    public T getById(Integer id) {
        D post = service.getById(id);
        return converter.toDTO(post);
    }

    @Override
    public List<T> getAll() {
        List<D> posts = service.getAll();
        if (posts == null) {
            return new ArrayList<>();
        }
        return posts.stream()
                .map(converter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Integer create(T postT) {

        D post = converter.toDomain(postT);

        return service.create(post);
    }

    @Override
    public void update(Integer id, T postT) {
        D post = converter.toDomain(postT);

        service.update(id, post);
    }


    @Override
    public Boolean deleteById(Integer id) {
        return service.deleteById(id);
    }


}
