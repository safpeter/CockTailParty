package com.codecool.cocktail.service;


import com.codecool.cocktail.model.Cocktail;
import com.codecool.cocktail.model.IngredientStore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Data
@NoArgsConstructor
public class CocktailFilter {

    public List<Cocktail> getFillteredCocktails(Set<Cocktail> allcocktails, IngredientStore ingredients){
        List<Cocktail> collect = allcocktails.stream().filter(cocktail -> cocktail.getIngredients().keySet().containsAll(ingredients.getIngredients()))
                .collect(Collectors.toList());
        return collect;
    }
}
