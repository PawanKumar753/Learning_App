package com.app.internship.controlle;

import com.app.internship.dto.InternshipResponseDto;
import com.app.internship.dto.RegisterRequestDto;
import com.app.internship.service.InternshipServiceInterface;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/internship")
@RequiredArgsConstructor
public class InternshipController {

    private final static Logger log = LoggerFactory.getLogger(InternshipController.class);

    private final InternshipServiceInterface internShip;

    @PostMapping("/create")
    public ResponseEntity<String> createIntership(@RequestBody RegisterRequestDto request){
        return ResponseEntity.ok(internShip.createInternship(request));
    }

    @GetMapping("/getInternship/{id}")
    public ResponseEntity<InternshipResponseDto> getInternship(@PathVariable Long id){
        return ResponseEntity.ok(internShip.getInternship(id));
    }

//    public ResponseEntity<List<InternshipResponseDto>> getAllInterships(){
//
//        return ResponseEntity.ok(internShip.);
//    }
}
