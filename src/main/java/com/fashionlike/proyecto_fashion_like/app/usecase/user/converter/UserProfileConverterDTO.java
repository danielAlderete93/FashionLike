package com.fashionlike.proyecto_fashion_like.app.usecase.user.converter;

import com.fashionlike.proyecto_fashion_like.app.usecase.converter.ConverterDTO;
import com.fashionlike.proyecto_fashion_like.app.usecase.post.dto.PostSummaryDTO;
import com.fashionlike.proyecto_fashion_like.app.usecase.user.dto.UserProfileDTO;
import com.fashionlike.proyecto_fashion_like.app.usecase.user.dto.UserSummaryDTO;
import com.fashionlike.proyecto_fashion_like.domain.model.Post;
import com.fashionlike.proyecto_fashion_like.domain.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserProfileConverterDTO {
    private ConverterDTO<User, UserSummaryDTO> userConverter;
    private ConverterDTO<Post, PostSummaryDTO> postConverter;

    public UserProfileDTO toDTO(User user, List<Post> postList) {
        UserSummaryDTO userDTO = userConverter.toDTO(user);
        List<PostSummaryDTO> postSummaryDTOS;

        postSummaryDTOS = postList.stream()
                .map(postConverter::toDTO)
                .collect(Collectors.toList());

        return UserProfileDTO.builder()
                .postDTO(postSummaryDTOS)
                .userDTO(userDTO)
                .build();
    }
}
