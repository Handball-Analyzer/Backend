package com.Handball.Analyzer.requestDtos.webfront.createDtos;

import lombok.Data;

@Data
public class ClubCreateDto {
    private String name;
    private int housenumber;
    private String location;
    private String street;
    private int plz;
}
