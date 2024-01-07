package com.Handball.Analyzer.controller;

import com.Handball.Analyzer.model.Settings;
import com.Handball.Analyzer.model.User;
import com.Handball.Analyzer.repository.UserRepository;
import com.Handball.Analyzer.requestDtos.AuthRequest;
import com.Handball.Analyzer.requestDtos.RegisterRequest;
import com.Handball.Analyzer.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/webfront/login")
    public ResponseEntity<String> webfrontLogin(@RequestBody AuthRequest authRequest){
        try {
            User user = userRepository.findByEmail(authRequest.getEmail()).orElseThrow();
            if(user.getActive()) {
                try {
                    Authentication authentication = authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    authRequest.getEmail(),
                                    authRequest.getPassword()
                            )
                    );
                    return ResponseEntity.ok(jwtTokenProvider.generateToken(authentication));
                }
                catch (Exception e){
                    return ResponseEntity.badRequest().build();
                }


            }
            return ResponseEntity.status(401).build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/backoffice/login")
    public ResponseEntity<String> backofficeLogin(@RequestBody AuthRequest authRequest){
        try {
            User user = userRepository.findByEmail(authRequest.getEmail()).orElseThrow();
            if(user.getRole().equals("admin") && user.getActive()) {
                try {
                    Authentication authentication = authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    authRequest.getEmail(),
                                    authRequest.getPassword()
                            )
                    );
                    return ResponseEntity.ok(jwtTokenProvider.generateToken(authentication));
                }
                catch (Exception e){
                    return ResponseEntity.badRequest().build();
                }


            }
            return ResponseEntity.status(401).build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        User newUser = new User(registerRequest.getFirstname(), registerRequest.getLastname(), registerRequest.getEmail(), null, passwordEncoder.encode(registerRequest.getPassword()), "user", new Settings("de", "light", null, null), true);
        User created = userRepository.save(newUser);

        return ResponseEntity.ok(created);
    }
}
