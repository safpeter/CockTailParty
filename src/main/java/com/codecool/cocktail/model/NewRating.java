package com.codecool.cocktail.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class NewRating {

    private String cocktailName;

    private String userName;

    private int rating;

    private String comment;
}
