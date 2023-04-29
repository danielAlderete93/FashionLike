package com.fashionlike.proyecto_fashion_like.domain.model.role;

import com.fashionlike.proyecto_fashion_like.domain.model.ActionType;

public class RoleAdmin extends Role {
    @Override
    public boolean canPerfomAction(ActionType action) {
        return true;
    }
}
