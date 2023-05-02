package com.fashionlike.proyecto_fashion_like.infra.adaptors.out.entity;

import com.fashionlike.proyecto_fashion_like.domain.model.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tags")
@AllArgsConstructor
@NoArgsConstructor
public class TagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;
    @Column
    private String name;
    @OneToMany
    private List<TagEntity> tags;
}
