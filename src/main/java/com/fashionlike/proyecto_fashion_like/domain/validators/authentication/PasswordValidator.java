package com.fashionlike.proyecto_fashion_like.domain.validators.authentication;

import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.validators.DomainValidator;
import com.fashionlike.proyecto_fashion_like.domain.validators.criteria.DomainValidationCriteria;

import java.util.List;

public class PasswordValidator extends DomainValidator<User> {

    public PasswordValidator(List<DomainValidationCriteria<User>> domainValidationCriteria) {
        super(domainValidationCriteria);
    }

    @Override
    public void validate(User user) {
        criteriaList.forEach(e -> e.validate(user));
    }
}
