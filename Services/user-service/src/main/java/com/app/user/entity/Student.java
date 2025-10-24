package com.app.user.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Student_Table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;

    private String sname;
    private String saddr;
    private String email;
    private Long mobile;
    private String password;

    private Boolean isVerified;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createdAt;
    private Set<String> courseList = new HashSet<>();

    @Lob
    @Column(name = "data", columnDefinition = "BLOB")
    private byte[] resume;
    

}
