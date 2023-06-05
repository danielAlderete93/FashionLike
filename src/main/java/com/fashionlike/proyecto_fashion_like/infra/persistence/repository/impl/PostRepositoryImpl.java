package com.fashionlike.proyecto_fashion_like.infra.persistence.repository.impl;

import com.fashionlike.proyecto_fashion_like.domain.model.Post;
import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.PostRepository;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.PostEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.entity.UserEntity;
import com.fashionlike.proyecto_fashion_like.infra.persistence.mapper.MapperPersistence;
import com.fashionlike.proyecto_fashion_like.infra.persistence.repository.PostRepositoryPersistenceJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
@AllArgsConstructor
public class PostRepositoryImpl implements PostRepository {
    private final PostRepositoryPersistenceJPA persistence;
    private final MapperPersistence<PostEntity, Post> postMapperPersistenceapperPersistence;
    private final MapperPersistence<UserEntity, User> userMapperPersistence;


    @Override
    public Optional<Post> findById(Integer id) {
        return persistence.findById(id)
                .flatMap(postMapperPersistenceapperPersistence::toDomain);
    }

    @Override
    public List<Post> findAll() {
        List<PostEntity> entities = persistence.findAll();

        return getListPostFromEntities(entities);
    }

    @Transactional
    @Override
    public Integer save(Post post) {
        Optional<PostEntity> postEntity = postMapperPersistenceapperPersistence.toEntity(post);

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

    @Override
    public List<Post> findAllForAuthor(User author) {
        UserEntity authorEntity = userMapperPersistence.toEntity(author).orElse(null);
        List<PostEntity> entities = new ArrayList<>(persistence.findAllPostsByAuthor(authorEntity));

        return getListPostFromEntities(entities);
    }

    private List<Post> getListPostFromEntities(List<PostEntity> entities) {
        return entities.stream()
                .map(postMapperPersistenceapperPersistence::toDomain)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

}
