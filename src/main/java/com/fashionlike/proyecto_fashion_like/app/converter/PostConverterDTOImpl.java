package com.fashionlike.proyecto_fashion_like.app.converter;

import com.fashionlike.proyecto_fashion_like.app.dto.PostDTO;
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
public class PostConverterDTOImpl implements ConverterDTO<Post, PostDTO> {

    private final UserService userService;
    private final TagService tagService;

    @Override
    public Post toDomain(PostDTO dto) {
        User author;
        List<Tag> tags;

        if (dto == null) {
            return null;
        }

        author = userService.getById(dto.getIdAuthor());
        tags = dto.getIdTags().stream().map(tagService::getById).collect(Collectors.toList());

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

        List<Integer> tags;

        if (domain == null) {
            return null;
        }

        tags = domain.getTags().stream().map(Tag::getId).collect(Collectors.toList());

        return PostDTO.builder()
                .id(domain.getId())
                .date(domain.getDate())
                .img(domain.getImg())
                .views(domain.getViews())
                .title(domain.getTitle())
                .idTags(tags)
                .idAuthor(domain.getAuthor().getId())
                .build();
    }
}
