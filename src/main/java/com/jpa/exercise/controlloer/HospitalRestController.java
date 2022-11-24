package com.jpa.exercise.controlloer;

import com.jpa.exercise.domain.dto.ReviewDTO;
import com.jpa.exercise.service.HospitalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/V2/hospital")
public class HospitalRestController {

    private final HospitalService hospitalService;

    public HospitalRestController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ReviewDTO>> getReviews(@PathVariable Long id) {
        List<ReviewDTO> reviews = hospitalService.getReviews(id);
        return ResponseEntity.ok().body(reviews);
    }
}
