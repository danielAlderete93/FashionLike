package com.fashionlike.proyecto_fashion_like.infra.security;

import com.fashionlike.proyecto_fashion_like.domain.model.User;
import com.fashionlike.proyecto_fashion_like.domain.port.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthenticationManagerImpl implements AuthenticationManager {
    private final UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        // Obtener el usuario desde el servicio de usuarios
        User user = userService.findByUsername(username);
        CustomUserDetails userDetails = new CustomUserDetails(user);
        // Crear una instancia de UsernamePasswordAuthenticationToken con los roles/permisos del usuario
        List<GrantedAuthority> authorities = userDetails.getAuthorities();
        return new UsernamePasswordAuthenticationToken(username, password, authorities);
    }
}
