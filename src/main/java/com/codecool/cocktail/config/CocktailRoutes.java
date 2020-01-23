package com.codecool.cocktail.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CocktailRoutes {

    @Value("${baseURL}")
    private String baseURL;

    private String[] letters = new String[]{"a", "b", "c",
            "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
            "q", "r", "s", "t", "u", "v", "w", "y", "x", "z", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "0"};

    private List<String> cocktailURLs = new ArrayList<>();


    public List<String> getCocktailURLs() {
        for (String c : letters) {
            cocktailURLs.add(String.format(baseURL, c));
        }
        return cocktailURLs;
    }
}
