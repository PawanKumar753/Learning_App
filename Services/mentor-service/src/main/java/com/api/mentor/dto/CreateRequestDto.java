package com.api.mentor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRequestDto {

    private String fullName;
    private Long mobileNumber;
    private String email;

    private String designation;
    private String department;
    private String specialization;

    private Boolean isActive;
    private int experienceYears;
}
