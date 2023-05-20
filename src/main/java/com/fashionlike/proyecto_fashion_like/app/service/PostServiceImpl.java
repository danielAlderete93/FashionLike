package com.fashionlike.proyecto_fashion_like.app.service;

import com.fashionlike.proyecto_fashion_like.domain.model.Post;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.PostRepository;
import com.fashionlike.proyecto_fashion_like.domain.port.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post getPostById(Integer id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Integer createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void updatePost(Integer id, Post post) {
        Post postToEdit = postRepository.findById(id).orElse(null);

        if (postToEdit == null) {
            postRepository.save(post);
        } else {
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
    public Boolean deletePostById(Integer id) {

        return postRepository.deleteById(id);
    }
}
