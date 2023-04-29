package com.fashionlike.proyecto_fashion_like.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reaction {
    private Long id;
    private User user;
    private Post post;
    private ReactionType type;


}
