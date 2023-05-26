package com.fashionlike.proyecto_fashion_like.app.usecase;

import com.fashionlike.proyecto_fashion_like.app.dto.TagDTO;
import com.fashionlike.proyecto_fashion_like.app.converter.ConverterDTO;
import com.fashionlike.proyecto_fashion_like.domain.model.Tag;
import com.fashionlike.proyecto_fashion_like.domain.port.service.TagService;
import com.fashionlike.proyecto_fashion_like.domain.usecase.TagUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class TagUseCaseImpl implements TagUseCase {
    private final TagService tagService;

    private final ConverterDTO<Tag, TagDTO> tagConverterDTO;

    @Override
    public TagDTO getById(Integer id) {
        Tag tag = tagService.getById(id);
        return tagConverterDTO.toDTO(tag);
    }

    @Override
    public List<TagDTO> getAll() {
        List<Tag> tags = tagService.getAll();
        return tags.stream()
                .map(tagConverterDTO::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Integer create(TagDTO tagDTO) {
        Tag tag = tagConverterDTO.toDomain(tagDTO);

        return tagService.create(tag);
    }

    @Override
    public void update(Integer id, TagDTO tagDTO) {
        Tag tag = tagConverterDTO.toDomain(tagDTO);

        tagService.update(id, tag);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return tagService.deleteById(id);
    }
}
