package com.app.user.service;

import com.app.user.dto.CreateDto;

public interface ServiceInterface {

    String createStudent(CreateDto request);

    String verifyStudent(String email);

    Boolean verifyOtp(Long otp);
    String hii();
}
