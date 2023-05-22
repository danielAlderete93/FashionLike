package com.fashionlike.proyecto_fashion_like.domain.validators.criteria;

import com.fashionlike.proyecto_fashion_like.domain.exceptions.UserDomainException;

public interface DomainValidationCriteria<T> {
    void validate(T o) throws UserDomainException;

}
