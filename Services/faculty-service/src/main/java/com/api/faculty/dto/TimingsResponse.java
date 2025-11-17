package com.api.faculty.dto;

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
public class TimingsResponse {

    private TimingStatus status;
    private LocalTime classStart;
    private LocalTime classEnd;
}
