package com.email.controller;

import com.email.Services.ServiceInterface;
import com.email.entity.Email;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EmailController {

    private final static Logger log = LoggerFactory.getLogger(EmailController.class);
    private final ServiceInterface emailService;
    {
        log.info("In email-service");
    }

    @PostMapping("/sendOTP")
    public ResponseEntity<String> sendOtp(@RequestBody Email request){
        log.info("In sendOTP() to send the otp to the " + request.getTo());
        return ResponseEntity.ok(emailService.sendOTP(request));
    }

    @GetMapping("verifyOTP/{otp}")
    public ResponseEntity<String> verifyOtp(@PathVariable Long otp){

        return ResponseEntity.ok(emailService.verifyOTP(otp));
    }
}
