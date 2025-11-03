package com.app.internship.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InternshipResponseDto {

    private Long id;

    private String imageURL;
    private String internshipTitle;
    private String domain;
    private String mode;
    private String description;

    private LocalDate startDate;
    private LocalDate endDate;

    private Double stipend;
    private String supervisorName;
    private String supervisorEmail;
}
