package com.fashionlike.proyecto_fashion_like.infra.persistence.repository.impl;

import com.fashionlike.proyecto_fashion_like.domain.model.Post;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.PostRepository;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.PostEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.mapper.MapperPersistence;
import com.fashionlike.proyecto_fashion_like.infra.persistence.repository.PostRepositoryPersistence;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostRepositoryImpl implements PostRepository {
    private final PostRepositoryPersistence persistence;
    private final MapperPersistence<PostEntity, Post> mapperPersistence;

    public PostRepositoryImpl(PostRepositoryPersistence persistence, MapperPersistence<PostEntity, Post> mapperPersistence) {
        this.persistence = persistence;
        this.mapperPersistence = mapperPersistence;
    }

    @Override
    public Post findById(Long id) {
        return persistence.findById(id).
                map(mapperPersistence::toDomain).
                orElse(null);
    }

    @Override
    public List<Post> findAll() {
        return persistence.findAll().stream()
                .map(mapperPersistence::toDomain)
                .collect(Collectors.toList())
                ;
    }

    @Override
    public void save(Post post) {
        PostEntity entity = mapperPersistence.toEntity(post);
        persistence.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        persistence.deleteById(id);
    }
}
