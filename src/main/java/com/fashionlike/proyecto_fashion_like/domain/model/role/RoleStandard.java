package com.fashionlike.proyecto_fashion_like.domain.model.role;

import com.fashionlike.proyecto_fashion_like.domain.model.ActionType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class RoleStandard extends Role {

    @Builder
    public RoleStandard(Integer id, List<ActionType> allowedActions) {
        super(id, allowedActions);
    }

    public RoleStandard() {
        this.allowedActions.add(ActionType.VIEW_POST);
    }

    @Override
    public boolean canPerfomAction(ActionType action) {
        return this.allowedActions.contains(action);
    }
}
