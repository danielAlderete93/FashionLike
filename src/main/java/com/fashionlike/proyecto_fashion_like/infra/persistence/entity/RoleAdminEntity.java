package com.fashionlike.proyecto_fashion_like.infra.persistence.entity;

import jakarta.persistence.DiscriminatorValue;

@DiscriminatorValue("admin")
public class RoleAdminEntity extends RoleEntity{
}
