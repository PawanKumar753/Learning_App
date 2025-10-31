package com.app.user.controller;

import com.app.user.dto.CreateDto;
import com.app.user.dto.LoginRequest;
import com.app.user.dto.RegisterRequestDTO;
import com.app.user.service.ServiceInterface;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class StudentController {

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);
    private final ServiceInterface userService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody CreateDto request){
        System.out.println(request);
        return ResponseEntity.ok(userService.createStudent(request));
    }



    @PostMapping("/register")
    public ResponseEntity<String> registerStudent(@RequestBody RegisterRequestDTO request){
        return ResponseEntity.ok(userService.registerStudent(request));
    }

    @GetMapping("/hii")
    public ResponseEntity<String> hello(){
        log.info("Calling /hii request");
        return ResponseEntity.ok(userService.hii());
    }

    @GetMapping("/verify/{email}")
    public ResponseEntity<String> verifyUser(@PathVariable String email){
        log.info("In VerifyUser()");
        return ResponseEntity.ok(userService.verifyStudent(email));
    }

    @GetMapping("/verifyOtp/{otp}")
    public ResponseEntity<String> verifyOtp(@PathVariable Long otp){
        log.info("In verifyOTP()");
        return ResponseEntity.ok(userService.verifyOtp(otp));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(userService.login(request));
    }

}
