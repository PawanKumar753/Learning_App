package com.api.mentor.services;

import com.api.mentor.dto.CreateRequestDto;
import com.api.mentor.dto.MentorResponseDto;

import java.util.List;
import java.util.Optional;

public interface MentorServiceInterface {

    String registerMentor(CreateRequestDto request);

    MentorResponseDto getMentor(Long id);

    Boolean isMentorPresent(Long id);

    List<MentorResponseDto> getAllMentors();
}
