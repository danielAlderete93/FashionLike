package com.fashionlike.proyecto_fashion_like.domain.model.role;

import com.fashionlike.proyecto_fashion_like.domain.model.ActionType;

import java.util.ArrayList;
import java.util.List;

public abstract class Role {
    protected List<ActionType> allowedActions;

    protected Role() {
        this.allowedActions = new ArrayList<>();
    }

    public void addAllowedAction(ActionType action) {
        this.allowedActions.add(action);
    }

    public void removeAllowedAction(ActionType action) {
        this.allowedActions.remove(action);
    }

    public abstract boolean canPerfomAction(ActionType action);
}
