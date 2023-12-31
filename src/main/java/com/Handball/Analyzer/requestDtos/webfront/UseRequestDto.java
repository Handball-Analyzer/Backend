package com.Handball.Analyzer.requestDtos.webfront;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UseRequestDto {

    private String firstname;
    private String lastname;
    private String clubName;
    private String email;
    private String message;

    public UseRequestDto(String firstname, String lastname, String clubName, String email, String message) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.clubName = clubName;
        this.email = email;
        this.message = message;
    }
}
