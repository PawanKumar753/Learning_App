package com.api.faculty.dto;

import com.api.faculty.entity.FacultyTimings;
import com.api.faculty.entity.Technology;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FacultyResponse {

    private Integer facultyId;

    private String name;
    private String email;
    private String number;

    private Double salary;
    private Double experience;

    private Boolean isActive;


    private List<TimingsResponse> facultyTimings;

    private List<TechnologiesResponse> technologies;
}
