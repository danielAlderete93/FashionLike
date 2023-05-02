package com.fashionlike.proyecto_fashion_like.infra.persistence.repository;

import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryPersistence extends JpaRepository<UserEntity, Long> {
}
