package com.jpa.exercise.service;

import com.jpa.exercise.domain.Hospital;
import com.jpa.exercise.domain.Review;
import com.jpa.exercise.domain.dto.AllReviewsResponse;
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

        List<AllReviewsResponse> allReviewsResponses = oneReviewsForAll(id);

        Optional<Hospital> byId = hospitalRepository.findById(id);
        Hospital hospital = byId.get();

        return new HospitalResponse(hospital.getName(), hospital.getRoadNameAddress(), allReviewsResponses);

    }

    public List<ReviewResponse> oneReviews(Integer id) {

        List<ReviewResponse> rr = new ArrayList<>();

        Optional<Hospital> byId = hospitalRepository.findById(id);
        Hospital hospital = byId.get();
        List<Review> reviews = hospital.getReviews();
        for (Review review : reviews) {
            rr.add(new ReviewResponse(review.getId(),review.getPatientName(),review.getTitle(),review.getContent(),review.getHospital().getName()));
        }
        return rr;
    }

    public List<AllReviewsResponse> oneReviewsForAll(Integer id) {

        List<AllReviewsResponse> rr = new ArrayList<>();

        Optional<Hospital> byId = hospitalRepository.findById(id);
        Hospital hospital = byId.get();
        List<Review> reviews = hospital.getReviews();
        for (Review review : reviews) {
            rr.add(new AllReviewsResponse(review.getId(),review.getPatientName(),review.getTitle(),review.getContent()));
        }
        return rr;
    }

}
