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
import java.util.Optional;
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
    public Optional<Post> findById(Integer id) {
        return persistence.findById(id)
                .flatMap(mapperPersistence::toDomain);
    }

    @Override
    public List<Post> findAll() {
        List<PostEntity> entities = persistence.findAll();

        return entities.stream()
                .map(mapperPersistence::toDomain)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Integer save(Post post) {
        Optional<PostEntity> postEntity = mapperPersistence.toEntity(post);

        if (postEntity.isEmpty()) {
            return null;
        }

        PostEntity savedEntity = persistence.save(postEntity.get());

        return savedEntity.getId();
    }

    @Transactional
    @Override
    public Boolean deleteById(Integer id) {
        if (!persistence.existsById(id)) {
            return false;
        }
        persistence.deleteById(id);
        return true;
    }

    @Override
    public boolean existsByTitle(String title) {
        return persistence.existsTitle(title);
    }

}
