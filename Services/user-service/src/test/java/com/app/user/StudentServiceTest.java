package com.app.user;

import com.app.user.entity.Student;
import com.app.user.repository.StudentRepository;

import com.app.user.service.ServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


public class StudentServiceTest {
    @Mock
    private  StudentRepository studentRepository;

    @InjectMocks
    private ServiceImpl studentService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUserById(){
        Student student = new Student();
        student.setSid(1L);
        student.setSname("Pavan");
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        Optional<Student> result = studentRepository.findById(1L);

        assertNotNull(result);
        assertEquals("Pavan", result.get().getSname());
        verify(studentRepository, times(1)).findById(1L);
    }

    @AfterEach
    void closeUp(){
        
    }


}
