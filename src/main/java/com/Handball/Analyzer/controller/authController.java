package com.Handball.Analyzer.controller;

import com.Handball.Analyzer.model.Settings;
import com.Handball.Analyzer.model.User;
import com.Handball.Analyzer.repository.UserRepository;
import com.Handball.Analyzer.requestDtos.AuthRequest;
import com.Handball.Analyzer.requestDtos.RegisterRequest;
import com.Handball.Analyzer.security.JwtTokenProvider;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth/v1")
public class authController {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private AuthenticationManager authenticationManager;

    private JwtTokenProvider jwtTokenProvider;

    public authController(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest registerRequest) {
        Optional<User> userOptional = userRepository.findByEmail(registerRequest.getEmail());

        if (userOptional.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        User newUser = new User(registerRequest.getFirstname(), registerRequest.getLastname(), registerRequest.getEmail(), registerRequest.getGender(), passwordEncoder.encode(registerRequest.getPassword()), "user", new Settings("de", "light", null, null), true);

        User created = userRepository.save(newUser);
        return ResponseEntity.ok(created);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getEmail(),
                        authRequest.getPassword()
                )
        );
        return ResponseEntity.ok(jwtTokenProvider.generateToken(authentication));
    }
}
