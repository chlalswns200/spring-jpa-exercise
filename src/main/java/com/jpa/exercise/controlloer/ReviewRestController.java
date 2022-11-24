package com.jpa.exercise.controlloer;

import com.jpa.exercise.domain.dto.ReviewCreateRequest;
import com.jpa.exercise.domain.dto.ReviewCreateResponse;
import com.jpa.exercise.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/hospital")
public class ReviewRestController {

    private final ReviewService reviewService;

    public ReviewRestController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewCreateResponse> get(@PathVariable Integer id, @RequestBody ReviewCreateRequest reviewCreateRequest) {
        return ResponseEntity.ok().body(reviewService.add(reviewCreateRequest));
    }

}
