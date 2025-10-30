package com.email.Services;

import com.email.entity.Email;

public interface ServiceInterface {

    String sendOTP(Email request);

    String verifyOTP(Long otp);
}
