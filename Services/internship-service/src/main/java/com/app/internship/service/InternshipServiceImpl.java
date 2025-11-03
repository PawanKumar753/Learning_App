package com.app.internship.service;

import com.app.internship.dto.InternshipResponseDto;
import com.app.internship.dto.RegisterRequestDto;
import com.app.internship.entity.Internship;
import com.app.internship.repository.InternshipRepository;
import com.app.internship.resttemplate.MentorTemplate;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InternshipServiceImpl implements InternshipServiceInterface {
    private final static Logger log = LoggerFactory.getLogger(InternshipServiceImpl.class);

    private final ModelMapper mapper;
    private final InternshipRepository internRepo;
    private final MentorTemplate mentorTemplate;

    @Override
    public String createInternship(RegisterRequestDto request) {
        if(!mentorTemplate.isMentorPresent(request.getMentorId())){
            throw new RuntimeException("No Mentor is find by " + request.getMentorId());
        }

        Internship internship = mapper.map(request, Internship.class);
        log.info("mapper id " + internship.getId());
        internship.setId(null);
        internRepo.save(internship);
        return "Internship created successfully";
    }

    @Override
    public InternshipResponseDto getInternship(Long id) {
        Optional<Internship> internship = internRepo.findById(id);
        if(internship.isEmpty()){
            throw new RuntimeException("No Internship is found by id " + id);
        }
        return mapper.map(internship.get(), InternshipResponseDto.class);
    }

    @Override
    public List<InternshipResponseDto> getAllInternships() {
        List<Internship> internshipList = internRepo.findAll();
        if(internshipList.isEmpty()){
            throw new RuntimeException("No internships are found");
        }
        return internshipList.stream().map(i -> mapper.map(i, InternshipResponseDto.class)).toList();
    }
}
