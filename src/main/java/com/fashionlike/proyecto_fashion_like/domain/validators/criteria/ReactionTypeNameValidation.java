package com.fashionlike.proyecto_fashion_like.domain.validators.criteria;

import com.fashionlike.proyecto_fashion_like.domain.exceptions.DomainException;
import com.fashionlike.proyecto_fashion_like.domain.exceptions.InvalidNameException;
import com.fashionlike.proyecto_fashion_like.domain.model.ReactionType;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.ReactionTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReactionTypeNameValidation implements DomainValidationCriteria<ReactionType> {
    private final ReactionTypeRepository reactionTypeRepository;

    @Override
    public void validate(ReactionType reactionType) throws DomainException {
        String name = reactionType.getName();
        if (reactionTypeRepository.existsByName(name)) {
            throw new InvalidNameException(name);
        }
    }
}