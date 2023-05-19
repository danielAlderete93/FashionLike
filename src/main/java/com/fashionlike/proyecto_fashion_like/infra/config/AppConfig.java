package com.fashionlike.proyecto_fashion_like.infra.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories("com.fashionlike.proyecto_fashion_like.infra.persistence.repository")
@ComponentScan("com.fashionlike.proyecto_fashion_like")
@EntityScan("com.fashionlike.proyecto_fashion_like.infra.persistence.entity")
public class AppConfig {

}
