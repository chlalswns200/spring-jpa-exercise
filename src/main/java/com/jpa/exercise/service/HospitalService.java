package com.jpa.exercise.service;

import com.jpa.exercise.domain.Hospital;
import com.jpa.exercise.domain.Review;
import com.jpa.exercise.domain.dto.ReviewDTO;
import com.jpa.exercise.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public List<ReviewDTO> getReviews(Long id) {

        Optional<Hospital> byId = hospitalRepository.findById(id);
        List<ReviewDTO> reviewDTOs = new ArrayList<>();

        List<Review> reviews = byId.get().getReviews();

        for (Review review : reviews) {
            reviewDTOs.add(new ReviewDTO(review.getId(),review.getTitle(),review.getContent()));
        }
        return reviewDTOs;
    }
}
