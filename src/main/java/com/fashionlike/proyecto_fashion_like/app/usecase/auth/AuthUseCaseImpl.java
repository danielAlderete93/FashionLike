package com.fashionlike.proyecto_fashion_like.app.usecase.auth;

import com.fashionlike.proyecto_fashion_like.app.provider.JwtTokenProvider;
import com.fashionlike.proyecto_fashion_like.app.usecase.auth.dto.LoginRequestDTO;
import com.fashionlike.proyecto_fashion_like.app.usecase.auth.dto.RegisterRequestDTO;
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
    public String login(LoginRequestDTO loginRequestDTO) throws InvalidCredentialsException {
        String password;
        String username;
        String token;
        String userId;
        User user;

        if (loginRequestDTO == null) {
            throw new InvalidCredentialsException("Invalid credentials. Login null");
        }
        password = loginRequestDTO.getPassword();
        username = loginRequestDTO.getUsername();
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
    public Integer register(RegisterRequestDTO registerRequestDTO) {


        validateRegister(registerRequestDTO);

        User user = getUserStandard(registerRequestDTO);


        return userService.create(user);
    }

    @Override
    public boolean activeUser(String token) {
        Integer idUser = jwtTokenProvider.getUserIdFromToken(token);
        User user = userService.getById(idUser);

        if (user == null) {
            return false;
        }

        user.setIsActive(true);

        userService.update(idUser, user);


        return true;


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

    @Override
    public String generateRegisterTokenForUserByID(Integer id) {
        User user = userService.getById(id);
        if (user == null) {
            return null;
        }

        return jwtTokenProvider.generateToken(user);
    }

    private void validateRegister(RegisterRequestDTO registerRequestDTO) {
        if (registerRequestDTO == null) {
            throw new InvalidRegisterException("Invalid register. The record is null");
        }

        if (registerRequestDTO.getUsername() == null && registerRequestDTO.getName() == null && registerRequestDTO.getPassword() == null) {
            throw new InvalidRegisterException("Invalid register. Username, name or password are null");
        }


    }

    private User getUserStandard(RegisterRequestDTO registerRequestDTO) {
        return User.builder()
                .name(registerRequestDTO.getName())
                .username(registerRequestDTO.getUsername())
                .password(registerRequestDTO.getPassword())
                .mail(registerRequestDTO.getMail())
                .role(Role.ROLE_USER)
                .isActive(false)
                .build();
    }

}

