package com.app.user.controller;

import com.app.user.dto.CreateDto;
import com.app.user.service.ServiceInterface;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class StudentController {

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);
    private final ServiceInterface userService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody CreateDto request){
        return ResponseEntity.ok(userService.createStudent(request));
    }

    @GetMapping("/hii")
    public ResponseEntity<String> hello(){
        log.info("Calling /hii request");
        return ResponseEntity.ok(userService.hii());
    }

    @GetMapping("/verify/{email}")
    public ResponseEntity<String> verifyUser(@RequestParam String email){
        return ResponseEntity.ok("user verified successfully");
    }

    @GetMapping("/verifyOtp/{otp}")
    public ResponseEntity<Boolean> verifyOtp(@RequestParam Long otp){
        return ResponseEntity.ok(false);
    }

}
