package com.fashionlike.proyecto_fashion_like.domain.model.role;

import com.fashionlike.proyecto_fashion_like.domain.model.ActionType;

public class RoleStandard extends Role {

    public RoleStandard() {
        this.allowedActions.add(ActionType.VIEW_POST);
    }

    @Override
    public boolean canPerfomAction(ActionType action) {
        return this.allowedActions.contains(action);
    }
}
