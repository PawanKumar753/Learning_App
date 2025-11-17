package com.api.faculty.dto.timings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllocateRequestDto {

    private Integer facultyId;
    private LocalTime classStart;
    private LocalTime classEnd;
}
