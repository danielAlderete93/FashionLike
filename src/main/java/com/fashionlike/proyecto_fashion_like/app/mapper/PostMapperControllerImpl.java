package com.fashionlike.proyecto_fashion_like.app.mapper;

import com.fashionlike.proyecto_fashion_like.app.dto.PostDTO;
import com.fashionlike.proyecto_fashion_like.app.dto.UserDTO;
import com.fashionlike.proyecto_fashion_like.domain.model.Post;
import com.fashionlike.proyecto_fashion_like.domain.model.Tag;
import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.port.service.TagService;
import com.fashionlike.proyecto_fashion_like.domain.port.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PostMapperControllerImpl implements MapperController<Post, PostDTO> {
    private final MapperController<User, UserDTO> userMapperController;
    private final UserService userService;
    private final TagService tagService;

    @Override
    public Post toDomain(PostDTO dto) {
        User author;
        List<Tag> tags;

        if (dto == null) {
            return null;
        }

        author = userService.getUserById(dto.getIdAuthor());
        tags = dto.getIdTags().stream().map(tagService::getTagById).collect(Collectors.toList());

        return Post.builder()
                .id(dto.getId())
                .date(dto.getDate())
                .img(dto.getImg())
                .views(dto.getViews())
                .title(dto.getTitle())
                .tags(tags)
                .author(author)
                .build();
    }

    @Override
    public PostDTO toDTO(Post domain) {
        return null;
    }
}
