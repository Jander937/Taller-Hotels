package com.co.buritica.hotels.services.impl;

import com.co.buritica.hotels.repositories.UserRepository;
import com.co.buritica.hotels.security.CustomerDetailsService;
import com.co.buritica.hotels.security.jwt.JwtUtil;
import com.co.buritica.hotels.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userDAO;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomerDetailsService customerDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        // Implementa la lógica de signUp aquí
        return null;
    }

    @Override
    public ResponseEntity<String> login(Map<String, String> requestMap) {
        log.info("Dentro de login");
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestMap.get("email"), requestMap.get("password"))
            );
            if (authentication.isAuthenticated()) {
                if (customerDetailsService.getUserDetail().getStatus()) {
                    String token = jwtUtil.generateToken(customerDetailsService.getUserDetail().getEmail(),
                            String.valueOf(customerDetailsService.getUserDetail().getUserTypesEntity()));
                    return ResponseEntity.ok("{\"token\":\"" + token + "\"}");
                } else {
                    return ResponseEntity.badRequest().body("{\"mensaje\":\"Espere la aprobacion del administrador\"}");
                }
            }
        } catch (Exception exception) {
            log.error("{}", exception);
        }
        return ResponseEntity.badRequest().body("{\"mensaje\":\"credenciales incorrectas\"}");
    }

    private boolean validateSignUpMap(Map<String, String> requestMap) {
        return requestMap.containsKey("nombre") && requestMap.containsKey("numeroContacto")
                && requestMap.containsKey("email") && requestMap.containsKey("password");
    }
}
