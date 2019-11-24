package com.codecool.cocktail.controller;

import com.codecool.cocktail.data.UserRepository;
import com.codecool.cocktail.model.AppUser;
import com.codecool.cocktail.model.UserCredentials;
import com.codecool.cocktail.security.JwtTokenServices;
import lombok.AllArgsConstructor;
import com.codecool.cocktail.model.Sign;
import com.codecool.cocktail.model.AppUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AppUser appUser;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenServices jwtTokenServices;


    public AuthController( AuthenticationManager authenticationManager, JwtTokenServices jwtTokenServices){
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        this.authenticationManager = authenticationManager;
        this.jwtTokenServices = jwtTokenServices;
    }


    @PostMapping("/signin")
    public boolean signin(@RequestBody Sign sign) {
        String email = sign.getMail();
        String username = sign.getName();
        String password = sign.getPassword();
        if (userRepository.existsByEmailAndUsername(email, username)) {
            log.info("cuccc");
            return false;
        }

        userRepository.saveAndFlush(AppUser.builder()
                .username(username)
                .email(email)
                .password(passwordEncoder.encode(password))
                .roles(Collections.singletonList("User"))
                .build());
        return true;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserCredentials data) {
        System.out.println(data.getPassword());
        System.out.println(data.getUsername());
        try {
            System.out.println(data);
            String username = data.getUsername();
            System.out.println("user: " + username + " pw: " + data.getPassword());
            // authenticationManager.authenticate calls loadUserByUsername in CustomUserDetailsService
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
            List<String> roles = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            String token = jwtTokenServices.createToken(username, roles);

            Map<Object, Object> model = new HashMap<>();
            model.put("token", token);
                return ResponseEntity.ok((model));
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }
}
