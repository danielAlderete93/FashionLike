package com.fashionlike.proyecto_fashion_like.app.dto;

import com.fashionlike.proyecto_fashion_like.domain.model.ActionType;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RoleDTO {
    private Integer id;
    private List<ActionType> allowedActions;
    private String name;
}
