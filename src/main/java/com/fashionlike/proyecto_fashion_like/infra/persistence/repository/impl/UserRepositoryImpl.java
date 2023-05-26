package com.fashionlike.proyecto_fashion_like.infra.persistence.repository.impl;

import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.UserRepository;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.UserEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.mapper.MapperPersistence;
import com.fashionlike.proyecto_fashion_like.infra.persistence.repository.UserRepositoryPersistenceJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryPersistenceJPA userRepositoryPersistenceJPA;
    private final MapperPersistence<UserEntity, User> userMapperPersistence;


    @Override
    public Optional<User> findById(Integer id) {
        return userRepositoryPersistenceJPA.findById(id)
                .flatMap(userMapperPersistence::toDomain);

    }

    @Override
    public List<User> findAll() {
        List<UserEntity> entities = userRepositoryPersistenceJPA.findAll();

        return entities.stream()
                .map(userMapperPersistence::toDomain)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    @Override
    public Integer save(User user) {
        Optional<UserEntity> userEntity = userMapperPersistence.toEntity(user);

        if (userEntity.isEmpty()) {
            return null;
        }

        UserEntity savedEntity = userRepositoryPersistenceJPA.save(userEntity.get());

        return savedEntity.getId();
    }

    @Override
    public Boolean deleteById(Integer id) {
        if (!userRepositoryPersistenceJPA.existsById(id)) {
            return false;
        }
        userRepositoryPersistenceJPA.deleteById(id);
        return true;
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepositoryPersistenceJPA.existsUsername(username);
    }

}
