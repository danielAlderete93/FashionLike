package com.fashionlike.proyecto_fashion_like.domain.validators.reactions;

import com.fashionlike.proyecto_fashion_like.domain.model.ReactionType;
import com.fashionlike.proyecto_fashion_like.domain.validators.DomainValidator;
import com.fashionlike.proyecto_fashion_like.domain.validators.criteria.DomainValidationCriteria;

import java.util.List;

public class ReactionTypeValidator extends DomainValidator<ReactionType> {

    public ReactionTypeValidator(List<DomainValidationCriteria<ReactionType>> domainValidationCriteria) {
        super(domainValidationCriteria);
    }
}
