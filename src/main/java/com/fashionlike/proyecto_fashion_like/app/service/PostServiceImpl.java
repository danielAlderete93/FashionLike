package com.fashionlike.proyecto_fashion_like.app.service;

import com.fashionlike.proyecto_fashion_like.domain.model.Post;
import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.PostRepository;
import com.fashionlike.proyecto_fashion_like.domain.port.service.PostService;
import com.fashionlike.proyecto_fashion_like.domain.validators.posts.PostValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private static final Date DATE_NOW = new Date();
    private static final Integer DEFAULT_VIEWS = 0;

    private final PostValidator validator;
    private final PostRepository postRepository;

    @Override
    public Post getById(Integer id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Integer create(Post post) {
        validator.validate(post);

        post.setDate(DATE_NOW);
        post.setViews(DEFAULT_VIEWS);

        return postRepository.save(post);
    }

    @Override
    public void update(Integer id, Post post) {
        Post postToEdit = postRepository.findById(id).orElse(null);

        if (postToEdit == null) {
            postRepository.save(post);
        } else {
            validator.validate(post);

            postToEdit.setImg(post.getImg());
            postToEdit.setTags(post.getTags());
            postToEdit.setDate(post.getDate());
            postToEdit.setTitle(post.getTitle());
            postToEdit.setDescription(post.getDescription());
            postToEdit.setViews(post.getViews());
            postRepository.save(postToEdit);
        }


    }

    @Override
    public Boolean deleteById(Integer id) {

        return postRepository.deleteById(id);
    }

    @Override
    public List<Post> getPostFromAuthor(User user) {
        return postRepository.findAllForAuthor(user);
    }
}
