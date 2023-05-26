package com.fashionlike.proyecto_fashion_like.app.converter;

import com.fashionlike.proyecto_fashion_like.app.dto.TagDTO;
import com.fashionlike.proyecto_fashion_like.domain.model.Tag;
import com.fashionlike.proyecto_fashion_like.domain.port.service.TagService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class TagConverterDTOImpl implements ConverterDTO<Tag, TagDTO> {

    private final TagService tagService;

    @Override
    public Tag toDomain(TagDTO dto) {
        List<Tag> tagList;

        if (dto == null) {
            return null;
        }
        tagList = dto.getTagsId().stream()
                .map(tagService::getById)
                .collect(Collectors.toList())
        ;
        return Tag.builder()
                .id(dto.getId())
                .name(dto.getName())
                .tags(tagList)
                .build();
    }

    @Override
    public TagDTO toDTO(Tag domain) {
        List<Integer> tagID;

        if (domain == null) {
            return null;
        }

        tagID = domain.getTags().stream()
                .map(Tag::getId)
                .collect(Collectors.toList())
        ;


        return TagDTO.builder()
                .id(domain.getId())
                .name(domain.getName())
                .tagsId(tagID)
                .build();
    }
}
