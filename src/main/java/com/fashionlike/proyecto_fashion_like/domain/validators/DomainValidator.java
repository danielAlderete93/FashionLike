package com.fashionlike.proyecto_fashion_like.domain.validators;

import com.fashionlike.proyecto_fashion_like.domain.validators.criteria.DomainValidationCriteria;

import java.util.List;

public abstract class DomainValidator<T> {

    protected List<DomainValidationCriteria<T>> criteriaList;

    protected DomainValidator() {
    }

    protected DomainValidator(List<DomainValidationCriteria<T>> criteriaList) {
        this.criteriaList = criteriaList;
    }

    public void validate(T t) {
        criteriaList.forEach(e -> e.validate(t));
    }
}
