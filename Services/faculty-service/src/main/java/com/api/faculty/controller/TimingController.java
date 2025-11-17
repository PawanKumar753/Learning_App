package com.api.faculty.controller;

import com.api.faculty.dto.TimingsResponse;
import com.api.faculty.dto.timings.AllocateRequestDto;
import com.api.faculty.services.timings.TimingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timings")
@RequiredArgsConstructor
public class TimingController {

    private final TimingService timingService;

    @GetMapping("/hii")
    public ResponseEntity<String> hii(){
        return ResponseEntity.ok("Hello");
    }

    @GetMapping("/getAllSlots/{id}")
    public ResponseEntity<List<TimingsResponse>> getFacultySlots(@PathVariable Integer id){
        return ResponseEntity.ok(timingService.getFacultySlots(id));
    }

    @PostMapping("/allocateSlot")
    public ResponseEntity<String> allocateSlot(@RequestBody AllocateRequestDto request){
        return ResponseEntity.ok(timingService.allocateSlot(request));
    }

}
