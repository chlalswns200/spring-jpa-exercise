package com.jpa.exercise.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewCreateResponse {

    private Long id;
    private String title;
    private String content;
    private String status;
}
