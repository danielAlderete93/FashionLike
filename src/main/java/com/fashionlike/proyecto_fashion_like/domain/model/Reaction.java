package com.fashionlike.proyecto_fashion_like.domain.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Reaction {
    private Long id;
    private User user;
    private Post post;
    private ReactionType type;


}
