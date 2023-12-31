package com.Handball.Analyzer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class UseRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String firstname;
    private String lastname;
    private String email;
    private String clubName;
    private String message;
    private Boolean answered;
    private Boolean finished;

    public UseRequest(String firstname, String lastname, String email, String clubName, String message, Boolean answered, Boolean finished) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.clubName = clubName;
        this.message = message;
        this.answered = answered;
        this.finished = finished;
    }
}
