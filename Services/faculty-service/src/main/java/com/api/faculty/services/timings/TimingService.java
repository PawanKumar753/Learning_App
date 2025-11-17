package com.api.faculty.services.timings;

import com.api.faculty.dto.TimingsResponse;
import com.api.faculty.dto.timings.AllocateRequestDto;

import java.util.List;

public interface TimingService {

    List<TimingsResponse> getFacultySlots(Integer facultyId);

    String allocateSlot(AllocateRequestDto request);

}
