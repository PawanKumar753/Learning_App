package com.api.faculty.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "TECHNOLOGY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer technologyId;

    private String technology;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;
}
