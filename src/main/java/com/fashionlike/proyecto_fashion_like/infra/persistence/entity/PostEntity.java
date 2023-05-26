package com.fashionlike.proyecto_fashion_like.infra.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity(name = "posts")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    @Column
    private String title;
    @Column
    private String img;
    @Column
    private String description;
    @Column
    private Date date;
    @Column
    private Integer views;
    @Column
    private Boolean isActive;

    @ManyToOne
    private UserEntity author;

    @OneToMany
    private List<TagEntity> tags;
}
