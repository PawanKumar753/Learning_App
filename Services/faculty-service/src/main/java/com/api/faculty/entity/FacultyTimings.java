package com.api.faculty.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Table(name = "FACULTY_TIMINGS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultyTimings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private TimingStatus status = TimingStatus.AVAILABLE;
    private LocalTime classStart;
    private LocalTime classEnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;


}
