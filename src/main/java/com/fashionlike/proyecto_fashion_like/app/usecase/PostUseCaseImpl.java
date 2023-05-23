package com.fashionlike.proyecto_fashion_like.app.usecase;

import com.fashionlike.proyecto_fashion_like.app.dto.PostDTO;
import com.fashionlike.proyecto_fashion_like.app.dto.TagDTO;
import com.fashionlike.proyecto_fashion_like.app.dto.UserDTO;
import com.fashionlike.proyecto_fashion_like.app.mapper.MapperController;
import com.fashionlike.proyecto_fashion_like.domain.model.Post;
import com.fashionlike.proyecto_fashion_like.domain.model.Tag;
import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.port.service.PostService;
import com.fashionlike.proyecto_fashion_like.domain.port.service.TagService;
import com.fashionlike.proyecto_fashion_like.domain.port.service.UserService;
import com.fashionlike.proyecto_fashion_like.domain.usecase.PostUseCase;
import com.fashionlike.proyecto_fashion_like.domain.validators.posts.PostValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PostUseCaseImpl implements PostUseCase {
    private final PostService postService;
    private final UserService userService;
    private final TagService tagService;
    private final PostValidator validator;
    private final MapperController<Post, PostDTO> postMapperController;
    private final MapperController<User, UserDTO> userMapperController;
    private final MapperController<Tag, TagDTO> tagMapperController;


    @Override
    public PostDTO getPostById(Integer id) {
        Post post = postService.getPostById(id);
        return postMapperController.toDTO(post);
    }

    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return posts.stream()
                .map(postMapperController::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Integer createPost(PostDTO postDTO) {
        Post post;
        User user;
        List<Tag> tags;

        user = userService.getUserById(postDTO.getIdAuthor());
        tags = postDTO.getIdTags().stream().map(tagService::getTagById).collect(Collectors.toList());


        post = Post.builder()
                .tags(tags)
                .img(postDTO.getImg())
                .title(postDTO.getTitle())
                .isActive(postDTO.getIsActive())
                .date(new Date())
                .author(user)
                .description(postDTO.getDescription())
                .build();

        validator.validate(post);

        return postService.createPost(post);
    }

    @Override
    public void updatePost(Integer id, PostDTO postDTO) {
        Post post;
        User user;
        List<Tag> tags;

        user = userService.getUserById(postDTO.getIdAuthor());
        tags = postDTO.getIdTags().stream().map(tagService::getTagById).collect(Collectors.toList());


        post = Post.builder()
                .tags(tags)
                .img(postDTO.getImg())
                .title(postDTO.getTitle())
                .isActive(postDTO.getIsActive())
                .date(new Date())
                .author(user)
                .description(postDTO.getDescription())
                .build();

        postService.updatePost(id, post);

    }

    @Override
    public void deletePostById(Integer id) {
        postService.deletePostById(id);
    }
}
