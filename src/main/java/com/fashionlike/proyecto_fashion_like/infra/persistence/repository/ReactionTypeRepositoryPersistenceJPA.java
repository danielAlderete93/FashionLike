package com.fashionlike.proyecto_fashion_like.infra.persistence.repository;

import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.ReactionTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionTypeRepositoryPersistenceJPA extends JpaRepository<ReactionTypeEntity, Integer> {

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM reaction_types r WHERE r.name = ?1")
    boolean existsName(String name);

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM reaction_types r WHERE r.emoji = ?1")
    boolean existsEmoji(String emoji);


}
