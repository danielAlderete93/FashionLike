package com.fashionlike.proyecto_fashion_like.domain.model.role;

import com.fashionlike.proyecto_fashion_like.domain.model.ActionType;
import lombok.Builder;

import java.util.List;


public class RoleAdmin extends Role {
    public RoleAdmin() {
    }

    @Builder
    public RoleAdmin(Integer id, List<ActionType> allowedActions) {
        super(id, allowedActions);
    }

    @Override
    public boolean canPerfomAction(ActionType action) {
        return true;
    }
}
