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
    public Tag getById(Integer id) {
        return tagRepository.findById(id).orElse(null);
    }

    @Override
    public List<Tag> getAll() {
        return tagRepository.findAll();
    }

    @Override
    public Integer create(Tag tag) {
        tagValidator.validate(tag);

        return tagRepository.save(tag);
    }

    @Override
    public void update(Integer id, Tag tag) {
        Tag tagToEdit = tagRepository.findById(id).orElse(null);

        if (tagToEdit == null) {
            create(tag);
        } else {
            tagValidator.validate(tag);
            tagToEdit.setTags(tag.getTags());
            tagToEdit.setName(tag.getName());
            tagRepository.save(tagToEdit);
        }

    }

    @Override
    public Boolean deleteById(Integer id) {
        return tagRepository.deleteById(id);
    }
}
