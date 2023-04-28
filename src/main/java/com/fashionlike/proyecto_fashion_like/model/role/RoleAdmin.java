package com.fashionlike.proyecto_fashion_like.model.role;

import com.fashionlike.proyecto_fashion_like.model.ActionType;

public class RoleAdmin extends Role {
    @Override
    public boolean canPerfomAction(ActionType action) {
        return true;
    }
}
