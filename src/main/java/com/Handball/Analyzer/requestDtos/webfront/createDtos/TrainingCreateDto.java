package com.Handball.Analyzer.requestDtos.webfront.createDtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class TrainingCreateDto {

    private LocalDateTime startDateTime;

    private UUID teamId;

    private UUID gymId;


}
