package com.fashionlike.proyecto_fashion_like.infra.persistence.repository.impl;

import com.fashionlike.proyecto_fashion_like.domain.port.repository.AuthTokenRepository;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Repository
public class RedisAuthTokenRepository implements AuthTokenRepository {

    private final JedisPool jedisPool;

    public RedisAuthTokenRepository() {
        // Configurar el pool de conexiones de Jedis
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        jedisPool = new JedisPool(poolConfig, "localhost", 6379);
    }


    @Override
    public void saveAuthToken(String userId, String token) {
        try (Jedis jedis = jedisPool.getResource()) {
            // Almacenar el token en Redis con una clave única basada en el ID del usuario
            jedis.set(userId, token);
                        // Establecer una expiración para el token (por ejemplo, 1 hora)
            jedis.expire(userId, 3600);
        }
    }

    @Override
    public String getAuthToken(String userId) {
        try (Jedis jedis = jedisPool.getResource()) {
            // Obtener el token almacenado en Redis para el ID de usuario proporcionado
            return jedis.get(userId);
        }
    }

    @Override
    public void deleteAuthToken(String userId) {
        try (Jedis jedis = jedisPool.getResource()) {
            // Eliminar el token almacenado en Redis para el ID de usuario proporcionado
            jedis.del(userId);
        }
    }
}
