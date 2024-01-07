package com.Handball.Analyzer.requestDtos.backoffice;

import lombok.Data;

import java.util.UUID;

@Data
public class ClubUserDto {
    private UUID clubId;
    private UUID userId;
}
