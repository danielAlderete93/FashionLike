package com.fashionlike.proyecto_fashion_like.infra.persistence.repository.impl;

import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.UserRepository;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.UserEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.mapper.MapperPersistence;
import com.fashionlike.proyecto_fashion_like.infra.persistence.mapper.UserMapperPersistence;
import com.fashionlike.proyecto_fashion_like.infra.persistence.repository.UserRepositoryPersistenceJPA;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryPersistenceJPA userRepositoryPersistenceJPA;
    private final MapperPersistence<UserEntity, User> userMapperPersistence;

    public UserRepositoryImpl(UserRepositoryPersistenceJPA userRepositoryPersistenceJPA) {
        this.userRepositoryPersistenceJPA = userRepositoryPersistenceJPA;
        this.userMapperPersistence = new UserMapperPersistence();
    }


    @Override
    public User findById(Integer id) {
        return userRepositoryPersistenceJPA.findById(id)
                .map(userMapperPersistence::toDomain)
                .orElse(null)
                ;
    }

    @Override
    public List<User> findAll() {
        return userRepositoryPersistenceJPA.findAll().stream()
                .map(userMapperPersistence::toDomain)
                .collect(Collectors.toList())
                ;
    }

    @Override
    public Integer save(User user) {
        UserEntity userEntity = userMapperPersistence.toEntity(user);
        return userRepositoryPersistenceJPA.save(userEntity).getId();
    }

    @Override
    public void deleteById(Integer id) {
        userRepositoryPersistenceJPA.deleteById(id);
    }
}
