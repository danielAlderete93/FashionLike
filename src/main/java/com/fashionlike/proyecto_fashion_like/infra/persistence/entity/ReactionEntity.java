package com.fashionlike.proyecto_fashion_like.infra.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "reactions")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ReactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    @ManyToOne
    private UserEntity user;
    @ManyToOne
    private PostEntity post;
    @ManyToOne
    private ReactionTypeEntity type;
}
