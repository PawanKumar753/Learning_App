package com.api.mentor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class MentorResponseDto {

    private Long id;
    private String fullName;
    private Long mobileNumber;
    private String email;

    private String designation;
    private String department;
    private String specialization;

    private Boolean isActive;
    private int experienceYears;
}
