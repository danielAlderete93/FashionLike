package com.fashionlike.proyecto_fashion_like.model.role;

import com.fashionlike.proyecto_fashion_like.model.ActionType;

public class RoleStandard extends Role {

    public RoleStandard() {
        this.allowedActions.add(ActionType.VIEW_POST);
    }

    @Override
    public boolean canPerfomAction(ActionType action) {
        return this.allowedActions.contains(action);
    }
}
