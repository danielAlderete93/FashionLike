package com.fashionlike.proyecto_fashion_like.domain.model;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {
    private Integer id;
    private String name;
    private String username;
    private String mail;
    private String password;
    private Boolean isActive;
    private Role role;

}
