package com.api.faculty.controller;

import brave.Response;
import com.api.faculty.dto.FacultyResponse;
import com.api.faculty.dto.RegisterRequest;
import com.api.faculty.services.FacultyService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5673")
@RestController
@RequestMapping("/api/faculty")
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyService facultyService;

    @GetMapping("/hii")
    public ResponseEntity<String> hii(){
        return ResponseEntity.ok("hello");
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerFaculty(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(facultyService.registerFaculty(request));
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<FacultyResponse>> getAllFaculties(){
        return ResponseEntity.ok(facultyService.getAllFaculties());
    }

    @GetMapping("/getFaculty/{id}")
    public ResponseEntity<FacultyResponse> getFacultyById(@PathVariable Integer id){
        return ResponseEntity.ok(facultyService.getFacultyById(id));
    }

}
