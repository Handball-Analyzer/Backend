package com.Handball.Analyzer.controller.backoffice;

import com.Handball.Analyzer.model.Club;
import com.Handball.Analyzer.model.ClubUser;
import com.Handball.Analyzer.model.Settings;
import com.Handball.Analyzer.model.User;
import com.Handball.Analyzer.repository.ClubRepository;
import com.Handball.Analyzer.repository.ClubUserRepository;
import com.Handball.Analyzer.repository.UserRepository;
import com.Handball.Analyzer.requestDtos.RegisterRequest;
import com.Handball.Analyzer.requestDtos.backoffice.CreateUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping ("/backoffice/v1/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    ClubRepository clubRepository;

    ClubUserRepository clubUserRepository;

    private PasswordEncoder passwordEncoder;

    public UserController( PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        List<User> userList = userRepository.findAll();
        return ResponseEntity.ok(userList);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        System.out.println("sds");

            if(userRepository.existsByEmail(registerRequest.getEmail())){
                return ResponseEntity.badRequest().build();
            }
            User newUser = new User(registerRequest.getFirstname(), registerRequest.getLastname(), registerRequest.getEmail(),null, passwordEncoder.encode(registerRequest.getPassword()), "user", new Settings("de", "light", null, null), true);
            User created = userRepository.save(newUser);
        System.out.println(created);
            if(registerRequest.getClubId() != null){
                System.out.println("sdsdsd");
                System.out.println(registerRequest.getClubId());
                try {
                    boolean test = clubRepository.existsById(registerRequest.getClubId());
                    System.out.println(test);
                    //Club club = clubRepository.findById(registerRequest.getClubId()).orElseThrow();

                    //ClubUser clubUser = new ClubUser(created, club);
                    return ResponseEntity.ok(created);
                }catch (Exception e){
                    return ResponseEntity.badRequest().build();
                }

            }

            return ResponseEntity.ok(created);



    }

    @PutMapping("/{userId}/changeactive")
    public ResponseEntity<?> changeActive(@PathVariable UUID userId) {
        try {
            User user = userRepository.findById(userId).orElseThrow();
            user.setActive(!user.getActive());
            userRepository.save(user);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }
    @PutMapping("/{userId}/password")
    public ResponseEntity<?> changePassword(@PathVariable UUID userId, @RequestBody String password) {
        String encodedPassword = passwordEncoder.encode(password);
        try {
            User user = userRepository.findById(userId).orElseThrow();
            user.setPassword(encodedPassword);
            userRepository.save(user);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }


}
