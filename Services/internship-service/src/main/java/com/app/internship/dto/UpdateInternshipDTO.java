package com.app.internship.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInternshipDTO {

    private Long id;
    private String imageURL;
    private String internshipTitle;
    private String domain;
    private String mode;
    private String description;

    private LocalDate startDate;
    private LocalDate endDate;

    private Double stipend;
    private Long mentorId;
}
