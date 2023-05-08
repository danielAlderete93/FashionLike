package com.fashionlike.proyecto_fashion_like.domain.model;

import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class Post {
    private Long id;
    private String title;
    private String img;
    private String description;
    private Date date;
    private Long views;
    private Boolean isActive;
    private List<Tag> tags;




}
