package com.codecool.cocktail.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class CnameAndUrl {

    private String name;
    private String url;

    public List<CnameAndUrl> convertCocktailsToCnameAndUrl(List<Cocktail> cocktails){
        return cocktails.stream().map(cocktail -> new CnameAndUrl(cocktail.getName(), cocktail.getPictureURL()))
                .collect(Collectors.toList());
    }
}
