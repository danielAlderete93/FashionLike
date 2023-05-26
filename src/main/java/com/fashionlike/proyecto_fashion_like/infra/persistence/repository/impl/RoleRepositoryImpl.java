package com.fashionlike.proyecto_fashion_like.infra.persistence.repository.impl;

import com.fashionlike.proyecto_fashion_like.domain.model.role.Role;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.RoleRepository;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.RoleEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.mapper.MapperPersistence;
import com.fashionlike.proyecto_fashion_like.infra.persistence.repository.RoleRepositoryPersistenceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("roleRepositoryImpl")
public class RoleRepositoryImpl implements RoleRepository {

    private final RoleRepositoryPersistenceJPA roleRepositoryPersistenceJPA;
    private final MapperPersistence<RoleEntity, Role> roleMapperPersistence;

    @Autowired
    public RoleRepositoryImpl(RoleRepositoryPersistenceJPA roleRepositoryPersistenceJPA, MapperPersistence<RoleEntity, Role> roleMapperPersistence) {
        this.roleRepositoryPersistenceJPA = roleRepositoryPersistenceJPA;
        this.roleMapperPersistence = roleMapperPersistence;
    }

    @Override
    public Optional<Role> findById(Integer id) {
        return roleRepositoryPersistenceJPA.findById(id)
                .map(roleMapperPersistence::toDomain)
                .orElse(null)
                ;
    }

    @Override
    public List<Role> findAll() {

        return roleRepositoryPersistenceJPA.findAll().stream()
                .map(roleMapperPersistence::toDomain)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    @Override
    public Integer save(Role role) {
        Optional<RoleEntity> roleEntity = roleMapperPersistence.toEntity(role);
        if (roleEntity.isEmpty()) {
            return null;
        }

        RoleEntity savedEntity = roleRepositoryPersistenceJPA.save(roleEntity.get());

        return savedEntity.getId();

    }

    @Override
    public Boolean deleteById(Integer id) {
        if (!roleRepositoryPersistenceJPA.existsById(id)) {
            return false;
        }
        roleRepositoryPersistenceJPA.deleteById(id);
        return true;
    }
}
