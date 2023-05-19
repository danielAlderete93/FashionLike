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
    public Post getPostById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public void createPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void updatePost(Long id, Post post) {
        Post postToEdit = postRepository.findById(id);
        postToEdit.setImg(post.getImg());
        postToEdit.setTags(post.getTags());
        postToEdit.setDate(post.getDate());
        postToEdit.setTitle(post.getTitle());
        postToEdit.setDescription(post.getDescription());
        postToEdit.setViews(post.getViews());
        postRepository.save(postToEdit);
    }

    @Override
    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }
}
