package com.fashionlike.proyecto_fashion_like.infra.persistence.entity;

import com.fashionlike.proyecto_fashion_like.domain.model.ActionType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "roles")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role_type", discriminatorType = DiscriminatorType.STRING)
public abstract class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    protected Integer id;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    protected List<ActionType> allowedActions;

    protected RoleEntity() {
    }

    protected RoleEntity(Integer id, List<ActionType> allowedActions) {
        this.id = id;
        this.allowedActions = allowedActions;
    }
}
