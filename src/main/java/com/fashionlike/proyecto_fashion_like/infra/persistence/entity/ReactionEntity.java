package com.fashionlike.proyecto_fashion_like.infra.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity(name = "reactions")
@AllArgsConstructor
@NoArgsConstructor
public class ReactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;
    @ManyToOne
    private UserEntity user;
    @ManyToOne
    private PostEntity post;
    @ManyToOne
    private ReactionTypeEntity type;
}
