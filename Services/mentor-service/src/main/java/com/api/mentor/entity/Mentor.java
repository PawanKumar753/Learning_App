package com.api.mentor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "MENTOR_TABLE")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private Long mobileNumber;
    private String email;

    private String designation;
    private String department;
    private String specialization;

    private Boolean isActive;
    private int experienceYears;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createdAt;

}
