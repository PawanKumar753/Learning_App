package com.app.user.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
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

    @Lob
    @Column(name = "data", columnDefinition = "BLOB")
    private byte[] resume;


    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Education> educationList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_interest",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "interest_id")
    )
    private Set<Intrests> interests = new HashSet<>();

}
