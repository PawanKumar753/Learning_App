package com.api.faculty.services;

import com.api.faculty.dto.FacultyResponse;
import com.api.faculty.dto.RegisterRequest;
import com.api.faculty.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FacultyService {

    String registerFaculty(RegisterRequest request);

    List<FacultyResponse> getAllFaculties();

    FacultyResponse getFacultyById(Integer id);

}
