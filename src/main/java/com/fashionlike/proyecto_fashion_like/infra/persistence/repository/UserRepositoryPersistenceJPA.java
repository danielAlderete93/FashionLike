package com.fashionlike.proyecto_fashion_like.infra.persistence.repository;

import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryPersistenceJPA extends JpaRepository<UserEntity, Integer> {
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM users u WHERE u.username = ?1")
    boolean existsUsername(String name);

    @Query("SELECT u FROM users u WHERE u.username = ?1")
    UserEntity findByUsername(String username);
}
