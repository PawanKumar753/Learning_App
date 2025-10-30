package com.app.user.resttemplates;

import com.app.user.dto.EmailRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "email-service")
public interface EmailServiceTemplate {

    @PostMapping("/api/email/sendOTP")
    String sendOtp(@RequestBody EmailRequest request);


    @GetMapping("/api/email/verifyOTP/{otp}")
    String verifyOtp(@PathVariable Long otp);
}
