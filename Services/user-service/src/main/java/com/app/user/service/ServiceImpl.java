package com.app.user.service;

import com.app.user.dto.CreateDto;
import com.app.user.dto.EmailRequest;
import com.app.user.entity.Student;
import com.app.user.repository.StudentRepository;
import com.app.user.resttemplates.EmailServiceTemplate;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class ServiceImpl implements ServiceInterface {

    private static final Logger log = LoggerFactory.getLogger(ServiceImpl.class);
    private StudentRepository studentRepo;
    private EmailServiceTemplate mailSender;
    private final BCryptPasswordEncoder encoder;

    @Override
    public String createStudent(CreateDto request){
        log.info("Creating the new Student Object.");
           try {
               if((studentRepo.findByEmail(request.getEmail())).isPresent()){
                    throw new RuntimeException("Student already exists");
               }
               Student student = new Student();
               student.setEmail(request.getEmail());
               student.setSname(request.getSname());
               student.setMobile(request.getMobile());
               student.setSaddr(request.getSaddr());
               student.setPassword(encoder.encode(request.getPassword()));
               student.setCourseList((Set<String>) request.getCourseList());
               studentRepo.save(student);
               log.info("Created the new Student successfully");
               return "Student created successfully.";
           } catch (Exception e){
               log.info("Insertion failed for student object.");
               return "Student object not inserted.";
           }
    }

    @Override
    public String verifyStudent(String email) {
        Optional<Student> existingStudent = studentRepo.findByEmail(email);
        if(existingStudent.isPresent()){
            Student student = existingStudent.get();
            EmailRequest mailRequest = new EmailRequest();
            mailRequest.setTo(email);
            mailRequest.setSubject("OTP Verification");
        } else {
            return "Student is not found by email " + email;
        }
        return null;
    }

    @Override
    public Boolean verifyOtp(Long otp) {
        return mailSender.verifyOtp(otp);
    }

    @Override
    public String hii() {
        log.info("in service inside hii()");
        return "Hello";
    }
}
