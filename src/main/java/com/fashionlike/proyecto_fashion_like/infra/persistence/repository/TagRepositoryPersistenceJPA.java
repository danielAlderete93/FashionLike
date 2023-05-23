package com.fashionlike.proyecto_fashion_like.infra.persistence.repository;

import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepositoryPersistenceJPA extends JpaRepository<TagEntity, Integer> {

    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END FROM TagEntity t WHERE t.name = ?1")
    boolean existsName(String name);


}
