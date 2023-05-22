package com.fashionlike.proyecto_fashion_like.infra.config;

import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.UserRepository;
import com.fashionlike.proyecto_fashion_like.domain.validators.authentication.AuthenticationValidator;
import com.fashionlike.proyecto_fashion_like.domain.validators.authentication.PasswordValidator;
import com.fashionlike.proyecto_fashion_like.domain.validators.criteria.DomainValidationCriteria;
import com.fashionlike.proyecto_fashion_like.domain.validators.criteria.PasswordValidationCriteria;
import com.fashionlike.proyecto_fashion_like.domain.validators.criteria.UsernameValidationCriteria;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AppConfig {

    private final UserRepository userRepository;

    @Autowired
    public AppConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public AuthenticationValidator authenticationValidator() {
        return new AuthenticationValidator(setCriteriaAuthentication());
    }

    @Bean
    public PasswordValidator passwordValidator() {
        return new PasswordValidator(setCriteriaPassword());
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

    @Bean
    public AuthenticationValidator customAuthenticationValidator() {
        return new AuthenticationValidator(setCriteriaAuthentication());
    }
}

