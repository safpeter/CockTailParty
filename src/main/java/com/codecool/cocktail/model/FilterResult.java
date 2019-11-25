package com.codecool.cocktail.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class FilterResult {

    private String name;
    private String url;
    private AlcoholContent alcoholContent;

    public List<FilterResult> convertCocktails(List<Cocktail> cocktails){
        return cocktails.stream().map(cocktail -> new FilterResult(cocktail.getName(), cocktail.getPictureURL(), cocktail.getAlcoholContent()))
                .collect(Collectors.toList());
    }
}
