package com.fashionlike.proyecto_fashion_like.infra.security;

import com.fashionlike.proyecto_fashion_like.app.provider.JwtTokenProvider;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {


    private JwtTokenProvider jwtTokenProvider;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = extractTokenFromRequest(httpServletRequest);

        if (token != null && jwtTokenProvider.validateToken(token)) {
            String username = jwtTokenProvider.getUsernameFromToken(token);
            Claims claims = jwtTokenProvider.getClaimsFromToken(token);

            // Obtener los claims personalizados del token (puedes adaptar esta lógica según tus necesidades)
            List<String> claimAuthorities = getClaimAuthorities(claims);

            // Convertir los claims en autoridades (GrantedAuthority)
            List<GrantedAuthority> authorities = claimAuthorities.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());

            // Crear la instancia de UserDetails y autenticar al usuario
            UserDetails userDetails = new User(username, "", authorities);
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }


    private String extractTokenFromRequest(HttpServletRequest request) {
        // Extraer el token del encabezado de la solicitud, por ejemplo, Authorization: Bearer <token>
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    private List<String> getClaimAuthorities(Claims claims) {
        List<String> authorities = new ArrayList<>();

        // Obtener las claims de autoridades del token
        List<String> claimAuthorities = claims.get("authorities", List.class);

        if (claimAuthorities != null) {
            // Agregar las autoridades a la lista
            authorities.addAll(claimAuthorities);
        }

        return authorities;
    }
}
