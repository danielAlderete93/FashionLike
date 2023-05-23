package com.fashionlike.proyecto_fashion_like.domain.validators.criteria;

import com.fashionlike.proyecto_fashion_like.domain.exceptions.DomainException;
import com.fashionlike.proyecto_fashion_like.domain.model.Post;

public class PostAuthorValidationCriteria implements DomainValidationCriteria<Post> {

    @Override
    public void validate(Post post) throws DomainException {
        if (post.getAuthor() == null) {
            throw new DomainException("The post must contain an author.");
        }
    }
}
