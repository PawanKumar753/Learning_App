package com.api.faculty.services.timings;

import com.api.faculty.dto.TimingsResponse;
import com.api.faculty.dto.timings.AllocateRequestDto;
import com.api.faculty.entity.FacultyTimings;
import com.api.faculty.entity.TimingStatus;
import com.api.faculty.repository.TimingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TimingServiceImpl implements TimingService{

    private final TimingsRepository timingsRepository;

    @Override
    public List<TimingsResponse> getFacultySlots(Integer facultyId) {
        List<FacultyTimings> timingsList = timingsRepository.findAllByFacultyFacultyId(facultyId);
        if (timingsList.isEmpty()){
            throw new RuntimeException("No Timings");
        }

        return timingsList.stream()
                .map(t -> TimingsResponse.builder()
                        .classEnd(t.getClassEnd())
                        .classStart(t.getClassStart())
                        .status(t.getStatus())
                        .build()
                )
                .collect(Collectors.toList());
    }

    @Override
    public String allocateSlot(AllocateRequestDto request) {

        List<FacultyTimings> timingsList = timingsRepository
                .findAllByFacultyFacultyIdAndStatus(request.getFacultyId(), TimingStatus.AVAILABLE);

        if(timingsList.isEmpty()){
            throw new RuntimeException("No Available Slots");
        }

        FacultyTimings timing = timingsList.stream()
                .filter(
                        t -> Objects.equals(t.getClassStart(), request.getClassStart()) &&
                             Objects.equals(t.getClassEnd(), request.getClassEnd())
                )
                .findFirst()
                .orElse(null);

        if(timing == null){
            return "Timing is not right";
        }

        timing.setStatus(TimingStatus.UNAVAILABLE);
        timingsRepository.save(timing);

        return "Timing is allocated";
    }
}
