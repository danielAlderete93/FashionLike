package com.fashionlike.proyecto_fashion_like.infra.persistence.repository.impl;

import com.fashionlike.proyecto_fashion_like.domain.model.Post;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.PostRepository;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.PostEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.mapper.MapperPersistence;
import com.fashionlike.proyecto_fashion_like.infra.persistence.mapper.PostMapperPersistence;
import com.fashionlike.proyecto_fashion_like.infra.persistence.repository.PostRepositoryPersistenceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Repository
public class PostRepositoryImpl implements PostRepository {
    private final PostRepositoryPersistenceJPA persistence;
    private final MapperPersistence<PostEntity, Post> mapperPersistence;

    @Autowired
    public PostRepositoryImpl(PostRepositoryPersistenceJPA persistence) {
        this.persistence = persistence;
        this.mapperPersistence = new PostMapperPersistence();
    }

    @Override
    public Post findById(Long id) {
        return persistence.findById(id).map(mapperPersistence::toDomain).orElse(null);
    }

    @Override
    public List<Post> findAll() {
        return persistence.findAll().stream().map(mapperPersistence::toDomain).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void save(Post post) {
        PostEntity entity = mapperPersistence.toEntity(post);
        persistence.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        persistence.deleteById(id);
    }
}
