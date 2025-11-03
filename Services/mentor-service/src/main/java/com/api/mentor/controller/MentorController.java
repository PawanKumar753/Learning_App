package com.api.mentor.controller;

import com.api.mentor.dto.CreateRequestDto;
import com.api.mentor.dto.MentorResponseDto;
import com.api.mentor.services.MentorServiceInterface;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mentor")
@RequiredArgsConstructor
public class MentorController {

    private final static Logger log = LoggerFactory.getLogger(MentorController.class);

    private final MentorServiceInterface mentorService;

    @PostMapping("/create")
    public ResponseEntity<String> registerMentor(@RequestBody CreateRequestDto request){
        return ResponseEntity.ok(mentorService.registerMentor(request));
    }

    @GetMapping("/getMentor/{id}")
    public ResponseEntity<MentorResponseDto> getMentor(@PathVariable Long id){
        return  ResponseEntity.ok(mentorService.getMentor(id));
    }

    @GetMapping("/isMentorPresent/{id}")
    public ResponseEntity<Boolean> isMentorPresent(@PathVariable Long id){
        return ResponseEntity.ok(mentorService.isMentorPresent(id));
    }

}
