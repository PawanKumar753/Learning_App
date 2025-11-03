package com.app.internship.service;

import com.app.internship.dto.InternshipResponseDto;
import com.app.internship.dto.RegisterRequestDto;

import java.util.List;

public interface InternshipServiceInterface {

    String createInternship(RegisterRequestDto request);

    InternshipResponseDto getInternship(Long id);

    List<InternshipResponseDto> getAllInternships();


}
