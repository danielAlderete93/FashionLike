package com.fashionlike.proyecto_fashion_like.infra.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity(name = "reaction_types")
@AllArgsConstructor
@NoArgsConstructor
public class ReactionTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;
    @Column
    private String name;
    @Column
    private Character emoji;
}
