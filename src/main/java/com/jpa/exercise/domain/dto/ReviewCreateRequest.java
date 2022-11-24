package com.jpa.exercise.domain.dto;

import com.jpa.exercise.domain.Hospital;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewCreateRequest {

    private String title;
    private String content;
    private String username;
    private Integer hospitalId;
}
