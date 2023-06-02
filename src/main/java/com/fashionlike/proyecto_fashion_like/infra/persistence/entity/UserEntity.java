package com.fashionlike.proyecto_fashion_like.infra.persistence.entity;

import com.fashionlike.proyecto_fashion_like.domain.model.Role;
import lombok.*;

import javax.persistence.*;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column
    private Boolean isActive;
    @Enumerated
    private Role role;


}
