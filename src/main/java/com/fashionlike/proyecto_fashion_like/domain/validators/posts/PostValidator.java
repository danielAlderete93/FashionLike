package com.fashionlike.proyecto_fashion_like.domain.validators.posts;

import com.fashionlike.proyecto_fashion_like.domain.model.Post;
import com.fashionlike.proyecto_fashion_like.domain.validators.DomainValidator;
import com.fashionlike.proyecto_fashion_like.domain.validators.criteria.DomainValidationCriteria;

import java.util.List;

public class PostValidator extends DomainValidator<Post> {

    public PostValidator(List<DomainValidationCriteria<Post>> domainValidationCriteria) {
        super(domainValidationCriteria);
    }
}
