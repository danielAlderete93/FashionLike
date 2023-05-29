package com.fashionlike.proyecto_fashion_like.app.usecase;

import com.fashionlike.proyecto_fashion_like.app.provider.JwtTokenProvider;
import com.fashionlike.proyecto_fashion_like.domain.exceptions.DomainException;
import com.fashionlike.proyecto_fashion_like.domain.exceptions.InvalidPasswordException;
import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.UserRepository;
import com.fashionlike.proyecto_fashion_like.domain.usecase.AuthUseCase;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthUseCaseImpl implements AuthUseCase {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;


    @Override
    public String login(String username, String password) throws DomainException {

        Optional<User> user = userRepository.findByUsername(username);


        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Invalid credentials");
        }


        if (!password.equals(user.get().getPassword())) {
            throw new InvalidPasswordException("Invalid credentials");
        }

        return jwtTokenProvider.generateToken(user.get());
    }

    // Otros métodos de la interfaz AuthUseCase
}

