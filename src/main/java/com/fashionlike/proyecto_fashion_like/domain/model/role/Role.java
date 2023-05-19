package com.fashionlike.proyecto_fashion_like.domain.model.role;

import com.fashionlike.proyecto_fashion_like.domain.model.ActionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public abstract class Role {
    protected Integer id;
    protected List<ActionType> allowedActions;
    protected String name;


    public void addAllowedAction(ActionType action) {
        this.allowedActions.add(action);
    }

    public void removeAllowedAction(ActionType action) {
        this.allowedActions.remove(action);
    }

    public abstract boolean canPerfomAction(ActionType action);
}
