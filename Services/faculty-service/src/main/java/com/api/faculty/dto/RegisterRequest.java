package com.api.faculty.dto;

import com.api.faculty.entity.FacultyTimings;
import com.api.faculty.entity.Technology;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String name;
    private String email;
    private String number;

    private Double salary;
    private Double experience;

    private List<FacultyTimings> facultyTimings;

    private List<Technology> technologies;
}
