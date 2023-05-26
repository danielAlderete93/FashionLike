package com.fashionlike.proyecto_fashion_like.app.usecase;

import com.fashionlike.proyecto_fashion_like.app.converter.ConverterDTO;
import com.fashionlike.proyecto_fashion_like.domain.port.service.BaseService;
import com.fashionlike.proyecto_fashion_like.domain.usecase.BaseUseCase;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseUseCaseImpl<DOMAIN, DTO> implements BaseUseCase<DTO> {
    private final BaseService<DOMAIN> service;

    private final ConverterDTO<DOMAIN, DTO> converter;

    protected BaseUseCaseImpl(BaseService<DOMAIN> service, ConverterDTO<DOMAIN, DTO> converter) {
        this.service = service;
        this.converter = converter;
    }

    @Override
    public DTO getById(Integer id) {
        DOMAIN post = service.getById(id);
        return converter.toDTO(post);
    }

    @Override
    public List<DTO> getAll() {
        List<DOMAIN> posts = service.getAll();
        return posts.stream()
                .map(converter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Integer create(DTO postDTO) {

        DOMAIN post = converter.toDomain(postDTO);

        return service.create(post);
    }

    @Override
    public void update(Integer id, DTO postDTO) {
        DOMAIN post = converter.toDomain(postDTO);

        service.update(id, post);
    }


    @Override
    public Boolean deleteById(Integer id) {
        return service.deleteById(id);
    }

}
