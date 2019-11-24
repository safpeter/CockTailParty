package com.codecool.cocktail.data;

import com.codecool.cocktail.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {


    Rating[] getRatingsByCocktailId(Long id);


}
