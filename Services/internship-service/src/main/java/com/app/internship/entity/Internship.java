package com.app.internship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "INTERNSHIP_TABLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Internship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageURL;
    private String internshipTitle;
    private String domain;
    private String mode;
    private String description;

    private LocalDate startDate;
    private LocalDate endDate;

    private Double stipend;
    private Long mentorId;

    @Enumerated(EnumType.STRING)
    private InternshipStatus status;

    private String remarks;




}
