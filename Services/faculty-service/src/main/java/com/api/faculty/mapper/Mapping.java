package com.api.faculty.mapper;

import com.api.faculty.dto.FacultyResponse;
import com.api.faculty.dto.RegisterRequest;
import com.api.faculty.dto.TechnologiesResponse;
import com.api.faculty.dto.TimingsResponse;
import com.api.faculty.entity.Faculty;
import com.api.faculty.entity.FacultyTimings;
import com.api.faculty.entity.Technology;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Mapping {

    public Faculty convertDtoToFaculty(RegisterRequest request){
        return Faculty.builder()
                .email(request.getEmail())
                .name(request.getName())
                .experience(request.getExperience())
                .technologies(request.getTechnologies())
                .salary(request.getSalary())
                .facultyTimings(request.getFacultyTimings())
                .number(request.getNumber())
                .build();
    }

    public List<FacultyResponse> entityToDto(List<Faculty> facultyList){

        return facultyList.stream()
                .map(f -> entityToResponse(f))
                .collect(Collectors.toList());

    }

    public FacultyResponse entityToResponse(Faculty faculty){
        return FacultyResponse.builder()
                .email(faculty.getEmail())
                .facultyId(faculty.getFacultyId())
                .isActive(faculty.getIsActive())
                .experience(faculty.getExperience())
                .facultyTimings(mapTimings(faculty.getFacultyTimings()))
                .name(faculty.getName())
                .technologies(mapTechnologies(faculty.getTechnologies()))
                .number(faculty.getNumber())
                .salary(faculty.getSalary())
                .build();
    }


    private List<TimingsResponse> mapTimings(List<FacultyTimings> timings){
        return timings.stream()
                .map(t -> TimingsResponse.builder()
                        .classStart(t.getClassStart())
                        .classEnd(t.getClassEnd())
                        .status(t.getStatus())
                        .build()
                )
                .collect(Collectors.toList());
    }

    private List<TechnologiesResponse> mapTechnologies(List<Technology> technologies){
        return technologies.stream()
                .map(t -> TechnologiesResponse.builder()
                        .technology(t.getTechnology())
                        .build()
                )
                .collect(Collectors.toList());
    }

}
