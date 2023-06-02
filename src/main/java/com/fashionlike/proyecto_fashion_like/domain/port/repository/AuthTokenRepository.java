package com.fashionlike.proyecto_fashion_like.domain.port.repository;

public interface AuthTokenRepository {
    void saveAuthToken(String userId, String token);

    String getAuthToken(String userId);

    void deleteAuthToken(String userId);
}
