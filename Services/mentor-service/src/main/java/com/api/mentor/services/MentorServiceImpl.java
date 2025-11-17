package com.api.mentor.services;

import com.api.mentor.dto.CreateRequestDto;
import com.api.mentor.dto.MentorResponseDto;
import com.api.mentor.entity.Mentor;
import com.api.mentor.repository.MentorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MentorServiceImpl implements MentorServiceInterface{

    private final static Logger log = LoggerFactory.getLogger(MentorServiceImpl.class);
    private final ModelMapper mapper;

    private final MentorRepository mentorRepository;


    @Override
    public String registerMentor(CreateRequestDto request) {
        Mentor mentor = mapper.map(request, Mentor.class);
        mentorRepository.save(mentor);
        return "Mentor created successfully";
    }

    @Override
    public MentorResponseDto getMentor(Long id) {
        Optional<Mentor> mentor = mentorRepository.findById(id);

        if(mentor.isEmpty()){
            throw new RuntimeException("No Mentor found by id " + id);
        }
        return mapper.map(mentor, MentorResponseDto.class);
    }

    @Override
    public Boolean isMentorPresent(Long id) {
        Optional<Mentor> mentor = mentorRepository.findById(id);

        return mentor.isPresent();
    }

    @Override
    public List<MentorResponseDto> getAllMentors() {
        List<Mentor> mentorList = mentorRepository.findAll();
        if (mentorList.isEmpty()){
            throw new RuntimeException("No Mentors found.");
        }
        return mentorList.stream()
                .map(m -> mapper.map(m, MentorResponseDto.class))
                .toList();
    }
}
