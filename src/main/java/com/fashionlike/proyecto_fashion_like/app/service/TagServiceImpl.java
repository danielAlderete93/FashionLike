package com.fashionlike.proyecto_fashion_like.app.service;

import com.fashionlike.proyecto_fashion_like.domain.model.Tag;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.TagRepository;
import com.fashionlike.proyecto_fashion_like.domain.port.service.TagService;
import com.fashionlike.proyecto_fashion_like.domain.validators.tag.TagValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;
    private final TagValidator tagValidator;

    @Override
    public Tag getTagById(Integer id) {
        return tagRepository.findById(id).orElse(null);
    }

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Integer createTag(Tag tag) {
        //validacion
        tagValidator.validate(tag);

        return tagRepository.save(tag);
    }

    @Override
    public void updateTag(Tag tag) {
        Tag tagToEdit = tagRepository.findById(tag.getId()).orElse(null);

        if (tagToEdit == null) {
            createTag(tag);
        } else {
            tagValidator.validate(tag);
            tagToEdit.setTags(tag.getTags());
            tagToEdit.setName(tag.getName());
            tagRepository.save(tagToEdit);
        }

    }

    @Override
    public Boolean deleteTagById(Integer id) {
        return tagRepository.deleteById(id);
    }
}
