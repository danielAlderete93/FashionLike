package com.fashionlike.proyecto_fashion_like.domain.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReactionType {
    private Long id;
    private String name;
    private Character emoji;

}
