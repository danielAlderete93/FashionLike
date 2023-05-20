package com.fashionlike.proyecto_fashion_like.infra.persistence.entity;

import com.fashionlike.proyecto_fashion_like.domain.model.ActionType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;

import java.util.List;

@Entity
@DiscriminatorValue("admin")
public class RoleAdminEntity extends RoleEntity {
    public RoleAdminEntity() {
        super();
    }

    @Builder
    public RoleAdminEntity(Integer id, List<ActionType> allowedActions) {
        super(id, allowedActions);
    }
}
