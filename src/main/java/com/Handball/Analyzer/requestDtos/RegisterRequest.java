package com.Handball.Analyzer.requestDtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class RegisterRequest {

    private String email;

    private String firstname;

    private String lastname;

    private String password;

    private UUID clubId;



    public RegisterRequest(String email, String firstname, String lastname, String password, UUID clubId) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.clubId = clubId;
    }


}
