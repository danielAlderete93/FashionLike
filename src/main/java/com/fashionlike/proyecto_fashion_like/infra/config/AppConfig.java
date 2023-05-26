package com.fashionlike.proyecto_fashion_like.infra.config;

import com.fashionlike.proyecto_fashion_like.domain.model.Post;
import com.fashionlike.proyecto_fashion_like.domain.model.ReactionType;
import com.fashionlike.proyecto_fashion_like.domain.model.Tag;
import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.PostRepository;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.ReactionTypeRepository;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.TagRepository;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.UserRepository;
import com.fashionlike.proyecto_fashion_like.domain.validators.authentication.AuthenticationValidator;
import com.fashionlike.proyecto_fashion_like.domain.validators.authentication.PasswordValidator;
import com.fashionlike.proyecto_fashion_like.domain.validators.criteria.*;
import com.fashionlike.proyecto_fashion_like.domain.validators.posts.PostValidator;
import com.fashionlike.proyecto_fashion_like.domain.validators.reactions.ReactionTypeValidator;
import com.fashionlike.proyecto_fashion_like.domain.validators.tag.TagValidator;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableJpaRepositories("com.fashionlike.proyecto_fashion_like.infra.persistence.repository")
@ComponentScan("com.fashionlike.proyecto_fashion_like")
@EntityScan("com.fashionlike.proyecto_fashion_like.infra.persistence.entity")
@AllArgsConstructor
public class AppConfig {

    private final UserRepository userRepository;

    private final ReactionTypeRepository reactionTypeRepository;
    private final PostRepository postRepository;
    private final TagRepository tagRepository;

    @Bean
    public AuthenticationValidator customAuthenticationValidator() {
        return new AuthenticationValidator(setCriteriaAuthentication());
    }

    @Bean
    public AuthenticationValidator authenticationValidator() {
        return new AuthenticationValidator(setCriteriaAuthentication());
    }

    @Bean
    public PasswordValidator passwordValidator() {
        return new PasswordValidator(setCriteriaPassword());
    }

    @Bean
    public PostValidator postValidator() {
        return new PostValidator(setCriteriaPost());
    }

    @Bean
    public TagValidator tagValidator() {
        return new TagValidator(setCriteriaTag());
    }

    @Bean
    public ReactionTypeValidator reactionTypeNameValidation() {

        return new ReactionTypeValidator(initReactionTypeValidator());

    }


    private List<DomainValidationCriteria<User>> setCriteriaAuthentication() {
        List<DomainValidationCriteria<User>> criteriaList = new ArrayList<>();
        criteriaList.add(new UsernameValidationCriteria(userRepository));
        criteriaList.add(new PasswordValidationCriteria());
        return criteriaList;
    }

    private List<DomainValidationCriteria<User>> setCriteriaPassword() {
        List<DomainValidationCriteria<User>> criteriaList = new ArrayList<>();
        criteriaList.add(new PasswordValidationCriteria());
        return criteriaList;
    }

    private List<DomainValidationCriteria<Post>> setCriteriaPost() {
        List<DomainValidationCriteria<Post>> criteriaList = new ArrayList<>();
        criteriaList.add(new PostTitleValidationCriteria(postRepository));
        criteriaList.add(new PostTagValidationCriteria());
        criteriaList.add(new PostAuthorValidationCriteria());
        return criteriaList;
    }

    private List<DomainValidationCriteria<Tag>> setCriteriaTag() {
        List<DomainValidationCriteria<Tag>> criteriaList = new ArrayList<>();
        criteriaList.add(new TagNameValidationCriteria(tagRepository));
        return criteriaList;
    }

    private List<DomainValidationCriteria<ReactionType>> initReactionTypeValidator() {
        List<DomainValidationCriteria<ReactionType>> criteriaList = new ArrayList<>();
        criteriaList.add(new EmojiValidationCriteria(reactionTypeRepository));
        criteriaList.add(new ReactionTypeNameValidation(reactionTypeRepository));
        return criteriaList;
    }


}

