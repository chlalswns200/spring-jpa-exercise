package com.jpa.exercise.domain.dto;

import com.jpa.exercise.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HospitalResponse {

    private String hospitalName;
    private String roadNameAddress;
    private List<ReviewResponse> hospitalReviews;

}
