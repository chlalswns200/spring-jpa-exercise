package com.jpa.exercise.service;

import com.jpa.exercise.domain.Hospital;
import com.jpa.exercise.domain.Review;
import com.jpa.exercise.domain.dto.HospitalResponse;
import com.jpa.exercise.domain.dto.ReviewResponse;
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

    public HospitalResponse hospitalAndReviews(Integer id) {

        List<ReviewResponse> reviewResponses = oneReviews(id);

        Optional<Hospital> byId = hospitalRepository.findById(id);
        Hospital hospital = byId.get();

        return new HospitalResponse(hospital.getName(), hospital.getRoadNameAddress(), reviewResponses);

    }

    public List<ReviewResponse> oneReviews(Integer id) {

        List<ReviewResponse> rr = new ArrayList<>();

        Optional<Hospital> byId = hospitalRepository.findById(id);
        Hospital hospital = byId.get();
        List<Review> reviews = hospital.getReviews();
        for (Review review : reviews) {
            rr.add(new ReviewResponse(review.getId(),review.getPatientName(),review.getTitle(),review.getContent()));
        }
        return rr;
    }

}
