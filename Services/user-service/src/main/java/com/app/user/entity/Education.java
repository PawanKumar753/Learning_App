package com.app.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "STUDENT_EDUCATION")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long educationId;

    private String institution;
    private String graduation;
    private String stream;
    private LocalDate yearOfPassing;
    private double percentage;

    @ManyToOne
    @JoinColumn(name = "student_Id")
    private Student student;

}
