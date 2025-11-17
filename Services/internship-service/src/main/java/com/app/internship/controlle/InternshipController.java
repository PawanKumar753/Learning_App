package com.app.internship.controlle;

import com.app.internship.dto.InternshipResponseDto;
import com.app.internship.dto.RegisterRequestDto;
import com.app.internship.dto.UpdateInternshipDTO;
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
    public ResponseEntity<String> createInternship(@RequestBody RegisterRequestDto request){
        log.info("in createInternship");
        return ResponseEntity.ok(internShip.createInternship(request));
    }

    @GetMapping("/getInternship/{id}")
    public ResponseEntity<InternshipResponseDto> getInternship(@PathVariable Long id){
        log.info("in getInternship");
        return ResponseEntity.ok(internShip.getInternship(id));
    }

    @GetMapping("/getAllInternships")
    public ResponseEntity<List<InternshipResponseDto>> getAllInternships(){
        log.info("in get allInternship");
        return ResponseEntity.ok(internShip.getAllInternships());
    }

    @PostMapping("/updateInternship")
    public ResponseEntity<String> updateInternship(@RequestBody UpdateInternshipDTO request){

        return null;
    }

    @GetMapping("/deleteInternship/{id}")
    public ResponseEntity<String> deleteInternship(@PathVariable Long id){
        log.info("in deleteInternship");
        return ResponseEntity.ok(internShip.deleteInternship(id));
    }
}
