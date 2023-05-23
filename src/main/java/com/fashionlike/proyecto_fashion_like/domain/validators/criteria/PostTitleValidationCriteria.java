package com.fashionlike.proyecto_fashion_like.domain.validators.criteria;

import com.fashionlike.proyecto_fashion_like.domain.exceptions.InvalidUsernameException;
import com.fashionlike.proyecto_fashion_like.domain.model.Post;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PostTitleValidationCriteria implements DomainValidationCriteria<Post> {
    private final PostRepository postRepository;

    @Override
    public void validate(Post post) {
        if (postRepository.existsByTitle(post.getTitle())) {
            throw new InvalidUsernameException(post.getTitle());
        }
    }
}
