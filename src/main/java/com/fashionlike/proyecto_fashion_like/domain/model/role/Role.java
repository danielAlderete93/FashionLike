package com.fashionlike.proyecto_fashion_like.domain.model.role;

import com.fashionlike.proyecto_fashion_like.domain.model.ActionType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class Role {
    protected Integer id;
    protected List<ActionType> allowedActions;

    protected Role() {
    }

    protected Role(Integer id, List<ActionType> allowedActions) {
        this.id = id;
        this.allowedActions = allowedActions;

    }

    public void addAllowedAction(ActionType action) {
        this.allowedActions.add(action);
    }

    public void removeAllowedAction(ActionType action) {
        this.allowedActions.remove(action);
    }

    public abstract boolean canPerfomAction(ActionType action);
}
