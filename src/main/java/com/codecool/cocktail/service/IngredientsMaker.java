package com.codecool.cocktail.service;

import com.codecool.cocktail.data.CocktailRepository;
import com.codecool.cocktail.model.Cocktail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientsMaker {

    @Autowired
    CocktailRepository cocktailRepository;


    private Set<String> allIngredients = new HashSet<>();

    public void generateIngredients(){
        Set<Cocktail> allcocktailes = cocktailRepository.getAllCocktailes();
        allcocktailes.forEach(cocktail -> allIngredients.addAll(cocktail.getIngredients().keySet()));
    }
}
