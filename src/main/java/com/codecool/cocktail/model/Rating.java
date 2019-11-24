package com.codecool.cocktail.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Rating implements Serializable {

    @Id
    @GeneratedValue
    private Long ratingId;

    @Column(nullable = false)
    private Long cocktailId;

    @Column(nullable=false)
    private Long userId;

    private String userName;

    private String comment;

    private int rating;

    private LocalDate date;

}

