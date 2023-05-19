package com.fashionlike.proyecto_fashion_like.infra.persistence.entity;

import com.fashionlike.proyecto_fashion_like.domain.model.ActionType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "name", discriminatorType = DiscriminatorType.STRING)
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    protected List<ActionType> allowedActions;
    @Column
    protected String name;


}
