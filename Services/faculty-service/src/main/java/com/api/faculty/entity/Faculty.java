package com.api.faculty.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@Table(name = "FACULTY")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "is_active = true")
@Builder
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer facultyId;

    private String name;
    private String email;
    private String number;

    private Double salary;
    private Double experience;

    private Boolean isActive;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FacultyTimings> facultyTimings;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
    private List<Technology> technologies;

    @PrePersist
    public void prePersist(){
        if (this.isActive == null){
            this.isActive = true;
        }
    }

}
