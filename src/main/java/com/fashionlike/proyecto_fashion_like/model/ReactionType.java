package com.fashionlike.proyecto_fashion_like.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReactionType {
    private Long id;
    private String name;
    private Character emoji;

}
