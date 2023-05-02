package com.fashionlike.proyecto_fashion_like.infra.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity(name = "posts")
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;
    @Column
    private String title;
    @Column
    private String img;
    @Column
    private String description;
    @Column
    private Date date;
    @Column
    private Long views;
    @Column
    private Boolean isActive;
    @OneToMany
    private List<TagEntity> tags;
}
