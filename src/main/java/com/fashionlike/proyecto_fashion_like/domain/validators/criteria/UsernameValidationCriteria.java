package com.fashionlike.proyecto_fashion_like.domain.validators.criteria;

import com.fashionlike.proyecto_fashion_like.domain.exceptions.InvalidUsernameException;
import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UsernameValidationCriteria implements DomainValidationCriteria<User> {
    private final UserRepository userRepository;


    @Override
    public void validate(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new InvalidUsernameException(user.getUsername());
        }
    }


}
