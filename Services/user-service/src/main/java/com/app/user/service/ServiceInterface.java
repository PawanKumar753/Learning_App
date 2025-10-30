package com.app.user.service;

import com.app.user.dto.CreateDto;
import com.app.user.dto.LoginRequest;
import com.app.user.dto.RegisterRequestDTO;

public interface ServiceInterface {

    String createStudent(CreateDto request);

    String registerStudent(RegisterRequestDTO request);

    String login(LoginRequest request);

    String verifyStudent(String email);

    String verifyOtp(Long otp);
    String hii();
}
