package com.fashionlike.proyecto_fashion_like.app.usecase.user.dto;

import com.fashionlike.proyecto_fashion_like.app.usecase.post.dto.PostSummaryDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserProfileDTO {
    UserSummaryDTO userDTO;
    List<PostSummaryDTO> postDTO;
}
