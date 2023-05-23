package com.fashionlike.proyecto_fashion_like.domain.validators.criteria;

import com.fashionlike.proyecto_fashion_like.domain.exceptions.DomainException;

public interface DomainValidationCriteria<T> {
    void validate(T o) throws DomainException;

}
