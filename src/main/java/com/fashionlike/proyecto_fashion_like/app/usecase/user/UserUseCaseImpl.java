package com.fashionlike.proyecto_fashion_like.app.usecase.user;

import com.fashionlike.proyecto_fashion_like.app.usecase.user.converter.UserProfileConverterDTO;
import com.fashionlike.proyecto_fashion_like.app.usecase.user.dto.UserProfileDTO;
import com.fashionlike.proyecto_fashion_like.domain.model.Post;
import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.port.service.PostService;
import com.fashionlike.proyecto_fashion_like.domain.port.service.UserService;
import com.fashionlike.proyecto_fashion_like.domain.usecase.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserUseCaseImpl implements UserUseCase {
    private final UserService userService;

    private final PostService postService;
    private final UserProfileConverterDTO converter;

    @Override
    public UserProfileDTO getProfile(String username) {
        User user = userService.findByUsername(username);
        List<Post> posts = postService.getPostFromAuthor(user);

        return converter.toDTO(user, posts);
    }
}
