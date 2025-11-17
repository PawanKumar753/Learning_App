package com.api.faculty.services;

import com.api.faculty.dto.FacultyResponse;
import com.api.faculty.dto.RegisterRequest;
import com.api.faculty.entity.Faculty;
import com.api.faculty.mapper.Mapping;
import com.api.faculty.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService{

    private final FacultyRepository facultyRepository;

    private final Mapping map;
    @Override
    public String registerFaculty(RegisterRequest request) {

        Optional<Faculty> isPresent = facultyRepository.findByEmailAndName(request.getEmail(), request.getName());

        if (isPresent.isPresent()){
            throw new RuntimeException("Faculty is already present.");
        }

        try {
            Faculty faculty = map.convertDtoToFaculty(request);
            if (faculty.getFacultyTimings() != null) {
                faculty.getFacultyTimings().forEach(timing -> timing.setFaculty(faculty));
            }

            if (faculty.getTechnologies() != null) {
                faculty.getTechnologies().forEach(tech -> tech.setFaculty(faculty));
            }
            facultyRepository.save(faculty);
            return "Registration successful";
        } catch (Exception e) {
            return "Registration failed: " + e.getMessage();
        }
    }

    @Override
    public List<FacultyResponse> getAllFaculties() {

        List<Faculty> facultiesList = facultyRepository.findAll();

        if(facultiesList.isEmpty()){
            throw new RuntimeException("No Faculties Found.");
        }
        return map.entityToDto(facultiesList);
    }

    @Override
    public FacultyResponse getFacultyById(Integer id) {
        Optional<Faculty> faculty = facultyRepository.findById(id);
        if(faculty.isEmpty()){
            throw new RuntimeException("No Faculty Found.");
        }
        return map.entityToResponse(faculty.get());
    }
}
