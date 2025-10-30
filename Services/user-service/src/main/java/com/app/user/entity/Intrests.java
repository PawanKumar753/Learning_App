package com.app.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "STUDENT_INTERESTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Intrests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interestId;

    private String technology;
    private String interestName;

    @ManyToMany(mappedBy = "interests")
    private Set<Student> students = new HashSet<>();
}
