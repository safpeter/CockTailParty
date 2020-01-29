package com.codecool.cocktail.service;

import com.codecool.cocktail.data.CocktailRepository;
import com.codecool.cocktail.model.Cocktail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientsMaker {

    @Autowired
    CocktailRepository cocktailRepository;


    private List<String> allIngredients;
    private Set<String> trimmedIngredients = new HashSet<>();

    public void generateIngredients(){
        Set<Cocktail> allCocktails = cocktailRepository.getAllCocktailes();
        allCocktails.forEach(cocktail -> trimmedIngredients.addAll(cocktail.getIngredients().keySet()));
        allIngredients = new ArrayList<>(trimmedIngredients);
        Collections.sort(allIngredients);


    }
}
