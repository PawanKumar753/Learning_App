package com.email.Services;

import com.email.entity.Email;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements ServiceInterface{

    private static final Logger log = LoggerFactory.getLogger(ServiceImpl.class);
    private static final Random random = new Random();
    private final JavaMailSender mailSender;
    private final StringRedisTemplate redisTemplate;

    @Override
    public String sendOTP(Email request) {

        log.info("in sendOTP()");
        Long otp = (long)(1000 + random.nextInt(9999));
        String message = "Enter below otp to verify your email.It is valid until 5 minutes " + otp;
        log.info("Storing the otp inside the redis");
        redisTemplate.opsForValue().set("otp", otp.toString(), 5, TimeUnit.MINUTES);
        log.info(otp + "otp created");
        Email mail = new Email(request.getSubject(), request.getTo(), message);
        boolean status = sendMail(mail);
        if(status){
            log.info("OTP sent successfully");
            return "OTP Sent Successfully";
        } else {
            log.info("OTP is unable to send to the mail");
            return "OTP sending failed";
        }

    }

    @Override
    public String verifyOTP(Long otp) {
       String otpValue = redisTemplate.opsForValue().get("otp");
       if(otpValue == null){
           return "Time expired";
       }

       Long sentOtp = Long.parseLong(otpValue);

       if(sentOtp.equals(otp)){
           return "email verified successfully";
       }else {
           return "Invalid OTP";
       }

    }

    private boolean sendMail(Email request) {
        log.info("In sendMail()");
        try {
            MimeMessage message = mailSender.createMimeMessage();
            log.info("Created MimeMessage.");
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            log.info("Created MimeMessageHelper.");
            helper.setTo(request.getTo());
            helper.setSubject(request.getSubject());
            helper.setText(request.getMessage());
            log.info("Sending the message to the mail.");
            mailSender.send(message);
            return true;
        } catch (Exception e){
            log.info("Failed to send the mail");
            e.printStackTrace();
            return false;
        }
    }
}
