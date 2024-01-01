package com.Handball.Analyzer.requestDtos.backoffice;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateUserDto {
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private UUID clubId;

}
