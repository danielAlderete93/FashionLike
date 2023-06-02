package com.fashionlike.proyecto_fashion_like.domain.model;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User implements Serializable {
    private Integer id;
    private String name;
    private String username;
    private String password;
    private Boolean isActive;
    private Role role;

}
