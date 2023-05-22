package com.fashionlike.proyecto_fashion_like.domain.validators.authentication;

import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.validators.DomainValidator;
import com.fashionlike.proyecto_fashion_like.domain.validators.criteria.DomainValidationCriteria;
import org.springframework.stereotype.Component;

import java.util.List;


@Component

public class AuthenticationValidator extends DomainValidator<User> {
    public AuthenticationValidator(List<DomainValidationCriteria<User>> domainValidationCriteria) {
        super(domainValidationCriteria);
    }

    @Override
    public void validate(User user) {
        criteriaList.forEach(e -> e.validate(user));
    }


}
