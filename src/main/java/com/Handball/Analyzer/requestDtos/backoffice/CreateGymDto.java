package com.Handball.Analyzer.requestDtos.backoffice;

import lombok.Data;

@Data
public class CreateGymDto {
    private String name;
    private String street;
    private Integer plz;
    private Integer housenumber;
    private String location;
}
