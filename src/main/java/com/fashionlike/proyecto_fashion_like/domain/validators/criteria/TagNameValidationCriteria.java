package com.fashionlike.proyecto_fashion_like.domain.validators.criteria;

import com.fashionlike.proyecto_fashion_like.domain.exceptions.DomainException;
import com.fashionlike.proyecto_fashion_like.domain.exceptions.InvalidTitleException;
import com.fashionlike.proyecto_fashion_like.domain.model.Tag;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.TagRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TagNameValidationCriteria implements DomainValidationCriteria<Tag> {
    private final TagRepository tagRepository;

    @Override
    public void validate(Tag tag) throws DomainException {
        String name = tag.getName();
        if (tagRepository.existsTitle(name)) {
            throw new InvalidTitleException(name);
        }
    }
}
