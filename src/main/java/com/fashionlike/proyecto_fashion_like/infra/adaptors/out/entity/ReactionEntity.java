package com.fashionlike.proyecto_fashion_like.infra.adaptors.out.entity;

import com.fashionlike.proyecto_fashion_like.domain.model.Post;
import com.fashionlike.proyecto_fashion_like.domain.model.ReactionType;
import com.fashionlike.proyecto_fashion_like.domain.model.User;
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
