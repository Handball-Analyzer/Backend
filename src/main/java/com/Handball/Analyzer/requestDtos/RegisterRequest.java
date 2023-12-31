package com.Handball.Analyzer.requestDtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterRequest {

    private String email;

    private String firstname;

    private String lastname;

    private String password;

    private String gender;


    public RegisterRequest(String email, String firstname, String lastname, String password, String gender) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.gender = gender;
    }


}
