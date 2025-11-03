package com.app.internship.resttemplate;

import com.app.internship.dto.MentorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "mentor-service")
public interface MentorTemplate {

    @GetMapping("/api/mentor/getMentor/{mentorId}")
    ResponseEntity<Optional<MentorDto>> getMentor(@PathVariable Long mentorId);

    @GetMapping("/api/mentor/isMentorPresent/{id}")
    Boolean isMentorPresent(@PathVariable Long id);
}
