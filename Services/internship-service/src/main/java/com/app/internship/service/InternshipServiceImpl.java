package com.app.internship.service;

import com.app.internship.dto.InternshipResponseDto;
import com.app.internship.dto.RegisterRequestDto;
import com.app.internship.dto.UpdateInternshipDTO;
import com.app.internship.entity.Internship;
import com.app.internship.repository.InternshipRepository;
import com.app.internship.resttemplate.MentorTemplate;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
        log.info("in getInternship()");
        Optional<Internship> internship = internRepo.findById(id);
        if(internship.isEmpty()){
            log.info("No Internship is found.");
            throw new RuntimeException("No Internship is found by id " + id);
        }

        log.info("Internship is found and returning.");
        return mapper.map(internship.get(), InternshipResponseDto.class);
    }

    @Override
    public List<InternshipResponseDto> getAllInternships() {

        log.info("Finding all the internships");
        List<Internship> internshipList = internRepo.findAll();
        if(internshipList.isEmpty()){
            log.info("No internships are found");
            throw new RuntimeException("No internships are found");
        }
        log.info("Returning all the found internships");
        return internshipList.stream().map(i -> mapper.map(i, InternshipResponseDto.class)).toList();
    }

    @Override
    public String updateInternship(UpdateInternshipDTO request) {
        log.info("finding the internship with id " + request.getId());
        Optional<Internship> internship = internRepo.findById(request.getId());
        if (internship.isEmpty()){
            log.info("no internship is found by id " + request.getId());
            throw new RuntimeException("No Internship is found by id " + request.getId());
        }

        log.info("Saving the updated internship");
        internRepo.save(mapper.map(request, Internship.class));
        return "Internship is updated";
    }

    @Override
    public String deleteInternship(Long id) {
        log.info("finding the internship with id " + id);
        Optional<Internship> internshipOptional = internRepo.findById(id);
        if (internshipOptional.isEmpty()){
            log.info("no internship is found by id " + id);
            throw new RuntimeException("No Internship is found by id " + id);
        }

        Internship internship = internshipOptional.get();
        internship.setIsDeleted(true);
        internRepo.save(internship);
        return "Internship is deleted with id " + id;
    }
}
