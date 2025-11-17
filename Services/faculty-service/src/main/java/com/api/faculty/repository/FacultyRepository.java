package com.api.faculty.repository;

import com.api.faculty.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

    Optional<Faculty> findByEmailAndName(String email, String name);
}
