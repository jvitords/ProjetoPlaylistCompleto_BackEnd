package com.playlist.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JwtServiceTest {

    private JwtService jwtService;

    @BeforeEach
    void setup() throws Exception {
        jwtService = new JwtService();

        // Injeta uma chave secreta manualmente no campo private
        Field secretKeyField = JwtService.class.getDeclaredField("secretKey");
        secretKeyField.setAccessible(true);
        secretKeyField.set(jwtService, "segredo-super-seguro-para-testes-123456");
    }

    @Test
    void testGenerateAndValidateToken() {
        String username = "testuser";
        String token = jwtService.generateToken(username);

        assertNotNull(token);
        assertTrue(jwtService.isTokenValid(token));
        assertEquals(username, jwtService.extractUsername(token));
    }

    @Test
    void testInvalidToken() {
        String invalidToken = "invalid.token.here";
        assertFalse(jwtService.isTokenValid(invalidToken));
    }
}