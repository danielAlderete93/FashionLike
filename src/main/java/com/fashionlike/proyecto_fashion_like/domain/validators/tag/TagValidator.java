package com.fashionlike.proyecto_fashion_like.domain.validators.tag;

import com.fashionlike.proyecto_fashion_like.domain.model.Tag;
import com.fashionlike.proyecto_fashion_like.domain.validators.DomainValidator;
import com.fashionlike.proyecto_fashion_like.domain.validators.criteria.DomainValidationCriteria;

import java.util.List;


public class TagValidator extends DomainValidator<Tag> {
    public TagValidator(List<DomainValidationCriteria<Tag>> domainValidationCriteria) {
        super(domainValidationCriteria);
    }
}
