package com.api.faculty.repository;

import com.api.faculty.entity.FacultyTimings;
import com.api.faculty.entity.TimingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimingsRepository extends JpaRepository<FacultyTimings, Integer> {

    List<FacultyTimings> findAllByFacultyFacultyId(Integer facultyId);

    List<FacultyTimings> findAllByFacultyFacultyIdAndStatus(Integer facultyId, TimingStatus status);

}
