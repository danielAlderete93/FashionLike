package com.fashionlike.proyecto_fashion_like.app.usecase;

import com.fashionlike.proyecto_fashion_like.app.dto.LoginRequest;
import com.fashionlike.proyecto_fashion_like.app.dto.RegisterRequest;
import com.fashionlike.proyecto_fashion_like.app.provider.JwtTokenProvider;
import com.fashionlike.proyecto_fashion_like.app.util.PasswordEncryptionUtil;
import com.fashionlike.proyecto_fashion_like.domain.exceptions.InvalidCredentialsException;
import com.fashionlike.proyecto_fashion_like.domain.exceptions.InvalidRegisterException;
import com.fashionlike.proyecto_fashion_like.domain.model.Role;
import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.port.repository.AuthTokenRepository;
import com.fashionlike.proyecto_fashion_like.domain.port.service.UserService;
import com.fashionlike.proyecto_fashion_like.domain.usecase.AuthUseCase;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class AuthUseCaseImpl implements AuthUseCase {

    private final UserService userService;
    private final AuthTokenRepository tokenRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    private final PasswordEncryptionUtil passwordEncryption;


    @Override
    public String login(LoginRequest loginRequest) throws InvalidCredentialsException {
        String password;
        String username;
        String token;
        String userId;
        User user;

        if (loginRequest == null) {
            throw new InvalidCredentialsException("Invalid credentials. Login null");
        }
        password = loginRequest.getPassword();
        username = loginRequest.getUsername();
        user = userService.findByUsername(username);

        verifyCredentials(username, password);


        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);


        token = jwtTokenProvider.generateToken(user);
        userId = user.getId().toString();

        tokenRepository.saveAuthToken(userId, token);

        return token;
    }

    @Override
    public Integer register(RegisterRequest registerRequest) {


        validateRegister(registerRequest);

        User user = getUserStandard(registerRequest);


        return userService.create(user);
    }

    @Override
    public void verifyCredentials(String username, String password) throws InvalidCredentialsException {


        User user = userService.findByUsername(username);

        if (user == null) {
            throw new InvalidCredentialsException("Invalid credentials. No exists");
        }

        if (!passwordEncryption.matches(password, user.getPassword())) {
            throw new InvalidCredentialsException("Invalid credentials. Password error");
        }


    }

    private void validateRegister(RegisterRequest registerRequest) {
        if (registerRequest == null) {
            throw new InvalidRegisterException("Invalid register. The record is null");
        }

        if (registerRequest.getUsername() == null && registerRequest.getName() == null && registerRequest.getPassword() == null) {
            throw new InvalidRegisterException("Invalid register. Username, name or password are null");
        }


    }

    private User getUserStandard(RegisterRequest registerRequest) {
        return User.builder()
                .name(registerRequest.getName())
                .username(registerRequest.getUsername())
                .password(registerRequest.getPassword())
                .mail(registerRequest.getMail())
                .role(Role.ROLE_USER)
                .isActive(false)
                .build();
    }

}

