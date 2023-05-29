package com.fashionlike.proyecto_fashion_like.infra.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "reaction_types")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ReactionTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    @Column
    private String name;
    @Column
    private String emoji;
}
