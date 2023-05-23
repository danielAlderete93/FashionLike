package com.fashionlike.proyecto_fashion_like.domain.validators.criteria;

import com.fashionlike.proyecto_fashion_like.domain.exceptions.DomainException;
import com.fashionlike.proyecto_fashion_like.domain.model.Post;

public class PostTagValidationCriteria implements DomainValidationCriteria<Post> {
    @Override
    public void validate(Post post) throws DomainException {
        if (notEmptyTags(post) && tagsContainsNulls(post)) {
            throw new DomainException("The post must not contain null tags.");
        }
    }

    private boolean notEmptyTags(Post post) {
        return !post.getTags().isEmpty();
    }

    private boolean tagsContainsNulls(Post post) {
        return post.getTags().contains(null);
    }
}
