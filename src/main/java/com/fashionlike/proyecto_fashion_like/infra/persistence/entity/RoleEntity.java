package com.fashionlike.proyecto_fashion_like.infra.persistence.entity;

import com.fashionlike.proyecto_fashion_like.domain.model.Role;
import lombok.*;

import javax.persistence.*;

@Entity(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private Role role;

}