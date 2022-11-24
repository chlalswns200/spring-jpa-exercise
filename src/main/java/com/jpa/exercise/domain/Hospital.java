package com.jpa.exercise.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
public class Hospital {

    @Id
    private Integer id;
    private String roadNameAddress;
    private String name;

    @OneToMany(mappedBy = "hospital",fetch= FetchType.LAZY)
    private List<Review> reviews;

}
