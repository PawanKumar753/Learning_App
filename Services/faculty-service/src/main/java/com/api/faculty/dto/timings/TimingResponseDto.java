package com.api.faculty.dto.timings;

import com.api.faculty.entity.TimingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimingResponseDto {

    private LocalTime classStart;
    private LocalTime classEnd;

    private TimingStatus status;
}
