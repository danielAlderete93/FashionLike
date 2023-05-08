package com.fashionlike.proyecto_fashion_like.infra.persistence.repository.impl;

import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.UserRepository;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.UserEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.mapper.MapperPersistence;
import com.fashionlike.proyecto_fashion_like.infra.persistence.repository.UserRepositoryPersistence;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class UserRepositoryPersistenceImpl implements UserRepository {

    private final UserRepositoryPersistence persistence;
    private final MapperPersistence<UserEntity, User> mapperPersistence;

    public UserRepositoryPersistenceImpl(UserRepositoryPersistence persistence, MapperPersistence<UserEntity, User> mapperPersistence) {
        this.persistence = persistence;
        this.mapperPersistence = mapperPersistence;
    }

    @Override
    public User findById(Long id) {
        return persistence.findById(id)
                .map(mapperPersistence::toDomain)
                .orElse(null)
                ;
    }

    @Override
    public List<User> findAll() {
        return persistence.findAll().stream()
                .map(mapperPersistence::toDomain)
                .collect(Collectors.toList())
                ;
    }

    @Override
    public void save(User user) {
        UserEntity userEntity = mapperPersistence.toEntity(user);
        persistence.save(userEntity);
    }

    @Override
    public void deleteById(Long id) {
        persistence.deleteById(id);
    }
}
