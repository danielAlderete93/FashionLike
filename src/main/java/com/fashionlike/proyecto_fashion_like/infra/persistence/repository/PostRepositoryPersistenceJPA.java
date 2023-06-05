package com.fashionlike.proyecto_fashion_like.infra.persistence.repository;

import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.PostEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepositoryPersistenceJPA extends JpaRepository<PostEntity, Integer> {

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM posts p WHERE p.title = ?1")
    boolean existsTitle(String name);

    @Query("SELECT p FROM posts p WHERE p.author = ?1")
    List<PostEntity> findAllPostsByAuthor(UserEntity author);
}
