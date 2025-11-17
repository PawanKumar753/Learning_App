package com.app.user.service;

import com.app.user.dto.CreateDto;
import com.app.user.dto.EmailRequest;
import com.app.user.dto.LoginRequest;
import com.app.user.dto.RegisterRequestDTO;
import com.app.user.entity.Education;
import com.app.user.entity.Intrests;
import com.app.user.entity.Student;
import com.app.user.repository.EducationRepository;
import com.app.user.repository.IntersetsRepository;
import com.app.user.repository.StudentRepository;
import com.app.user.resttemplates.EmailServiceTemplate;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;


@Service
@RequiredArgsConstructor
public class ServiceImpl implements ServiceInterface {

    private static final Logger log = LoggerFactory.getLogger(ServiceImpl.class);
    private final StudentRepository studentRepo;
    private final EmailServiceTemplate mailSender;
    private final LoginAttemptService loginService;
    private final EducationRepository educationRepository;
    private final IntersetsRepository intersetsRepository;

    private final PasswordEncoder encoder;

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
//               student.setCourseList((Set<String>) request.getCourseList());
               studentRepo.save(student);
               log.info("Created the new Student successfully");
               return "Student created successfully.";
           } catch (Exception e){
               e.printStackTrace();
               log.info("Insertion failed for student object.");
               return "Student object not inserted.";
           }
    }

    @Override
    public String registerStudent(RegisterRequestDTO request) {
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

            List<Education> educationList = new ArrayList<>();

            request.getEducationList()
                    .forEach(e -> {
                        Education education = new Education();
                        education.setGraduation(e.getGraduation());
                        education.setInstitution(e.getInstitution());
                        education.setStream(e.getStream());
                        education.setYearOfPassing(e.getYearOfPassing());
                        education.setPercentage(e.getPercentage());
                        education.setStudent(student);


                        educationList.add(education);
                    });

            Set<Intrests> intrestsSet = new HashSet<>();

            request.getIntrests()
                            .forEach(i -> {
                                Intrests intrests = new Intrests();
                                intrests.setTechnology(i.getTechnology());
                                intrests.setInterestName(i.getInterestName());

                                intrestsSet.add(intrests);
                            });

            student.setInterests(intrestsSet);
            student.setEducationList(educationList);

            studentRepo.save(student);
            log.info("Created the new Student successfully");
            return "Student created successfully.";
        } catch (Exception e){
            e.printStackTrace();
            log.info("Insertion failed for student object.");
            return "Student object not inserted.";
        }
    }

    @Override
    public String login(LoginRequest request) {

        if(loginService.isBlocked(request.getEmail())){
            return "Your account is locked for 10 minutes due to multiple failed login attempts.";
        }

        Optional<Student> isStudent = studentRepo.findByEmail(request.getEmail());
        if(isStudent.isEmpty()){
            throw new RuntimeException("User does not exist");
        }
        Student student = isStudent.get();

        if(!encoder.matches(request.getPassword(), student.getPassword())){
            loginService.recordFailedAttempt(student.getEmail());
            return "Invalid Credentials";
        }

        loginService.resetAttempts(student.getEmail());
        return "Login Successful";
    }

    @Override
    public String verifyStudent(String email) {
        log.info("in VerifyStudent()");
        Optional<Student> existingStudent = studentRepo.findByEmail(email);
        if(existingStudent.isPresent()){
            EmailRequest mailRequest = new EmailRequest();
            mailRequest.setTo(email);
            mailRequest.setSubject("OTP Verification");
            log.info("Sending mail to the " + email);
            return mailSender.sendOtp(mailRequest);
        } else {
            return "Student is not found by email " + email;
        }
    }

    @Override
    public String verifyOtp(Long otp) {
        return mailSender.verifyOtp(otp);
    }

    @Override
    public String hii() {
        log.info("in service inside hii()");
        Map<String, Object> ex = new HashMap<>();
        List<Integer> list = new LinkedList<>();

        List<Integer> list2 = new ArrayList<>();

        Map<String, String> map2 = new ConcurrentHashMap<>();
        Collections.synchronizedMap(map2);
        return "Hello";
    }
}
