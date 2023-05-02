package com.fashionlike.proyecto_fashion_like.infra.adaptors.out.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;
    @Column
    private String name;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private Boolean isActive;

    /*
    @Transient
    private Role rol;
     */
}