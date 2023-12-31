package com.Handball.Analyzer.requestDtos;

import lombok.Data;

@Data
public class AuthRequest {

    private String email;

    private String password;

    public AuthRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
