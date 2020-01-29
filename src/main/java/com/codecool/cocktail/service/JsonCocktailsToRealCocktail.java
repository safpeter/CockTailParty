package com.codecool.cocktail.service;


import com.codecool.cocktail.model.AlcoholContent;
import com.codecool.cocktail.model.Cocktail;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JsonCocktailsToRealCocktail {

    public List<Cocktail> createCocktails(List<JsonNode> cocktailesJson) {
        List<Cocktail> cocktailList = new ArrayList<>();
        if (cocktailesJson != null) {
            for (JsonNode cocktail : cocktailesJson) {
                Cocktail cocktail1 = new Cocktail();
                cocktail1.setName(cocktail.findValue("strDrink").asText());
                cocktail1.setType(cocktail.findValue("strTags").asText());
                cocktail1.setCategory(cocktail.findValue("strCategory").asText());
                cocktail1.setAlcoholContent(AlcoholContent.getEnumAlcoholFromString(cocktail.findValue("strAlcoholic").asText()));
                cocktail1.setGlassType(cocktail.findValue("strGlass").asText());
                cocktail1.setRecipe(cocktail.findValue("strInstructions").asText());
                cocktail1.setPictureURL(cocktail.findValue("strDrinkThumb").asText());
                cocktail1.setIngredients(generateIngredients(cocktail));
                cocktailList.add(cocktail1);
            }
            return cocktailList;
        }
        return null;
    }

    private Map<String, String> generateIngredients(JsonNode cocktail) {

        Map<String, String> ingredientsAndMeasure = new HashMap<>();
        List<String> liveNums = getNumbers(cocktail);
        for (String num : liveNums) {
            if (cocktail.findValue("strIngredient" + num).asText().toLowerCase().equals("lemon juice")) {
                ingredientsAndMeasure.put("Lemon juice", cocktail.findValue("strMeasure" + num).asText());
            } else if (cocktail.findValue("strIngredient" + num).asText().toLowerCase().equals("egg white")) {
                ingredientsAndMeasure.put("Egg white", cocktail.findValue("strMeasure" + num).asText());
            } else if (cocktail.findValue("strIngredient" + num).asText().toLowerCase().equals("egg yolk")) {
                ingredientsAndMeasure.put("Egg yolk", cocktail.findValue("strMeasure" + num).asText());
            } else if (cocktail.findValue("strIngredient" + num).asText().toLowerCase().equals("gin")) {
                ingredientsAndMeasure.put("Gin", cocktail.findValue("strMeasure" + num).asText());
            } else if (cocktail.findValue("strIngredient" + num).asText().toLowerCase().equals("orange juice")) {
                ingredientsAndMeasure.put("Orange juice", cocktail.findValue("strMeasure" + num).asText());
            } else if (cocktail.findValue("strIngredient" + num).asText().toLowerCase().equals("orange peel")) {
                ingredientsAndMeasure.put("Orange peel", cocktail.findValue("strMeasure" + num).asText());
            } else if (cocktail.findValue("strIngredient" + num).asText().toLowerCase().equals("orange bitters")) {
                ingredientsAndMeasure.put("Orange bitters", cocktail.findValue("strMeasure" + num).asText());
            } else if (cocktail.findValue("strIngredient" + num).asText().toLowerCase().equals("lemon")) {
                ingredientsAndMeasure.put("Lemon", cocktail.findValue("strMeasure" + num).asText());
            } else if (cocktail.findValue("strIngredient" + num).asText().toLowerCase().equals("tonic water")) {
                ingredientsAndMeasure.put("Tonic water", cocktail.findValue("strMeasure" + num).asText());
            } else if (cocktail.findValue("strIngredient" + num).asText().toLowerCase().equals("sugar syrup")) {
                ingredientsAndMeasure.put("Sugar syrup", cocktail.findValue("strMeasure" + num).asText());
            } else if (cocktail.findValue("strIngredient" + num).asText().toLowerCase().equals("soda water")) {
                ingredientsAndMeasure.put("Soda water", cocktail.findValue("strMeasure" + num).asText());
            } else if (cocktail.findValue("strIngredient" + num).asText().toLowerCase().equals("angostura bitters")) {
                ingredientsAndMeasure.put("Angostura bitters", cocktail.findValue("strMeasure" + num).asText());
            } else if (cocktail.findValue("strIngredient" + num).asText().toLowerCase().equals("apricot brandy")) {
                ingredientsAndMeasure.put("Apricot brandy", cocktail.findValue("strMeasure" + num).asText());
            } else if (cocktail.findValue("strIngredient" + num).asText().toLowerCase().equals("cranberry juice")) {
                ingredientsAndMeasure.put("Cranberry juice", cocktail.findValue("strMeasure" + num).asText());
            } else if (cocktail.findValue("strIngredient" + num).asText().toLowerCase().equals("dark rum")) {
                ingredientsAndMeasure.put("Dark Rum", cocktail.findValue("strMeasure" + num).asText());
            } else if (cocktail.findValue("strIngredient" + num).asText().toLowerCase().equals("grapefruit juice")) {
                ingredientsAndMeasure.put("Grapefruit juice", cocktail.findValue("strMeasure" + num).asText());
            } else if (cocktail.findValue("strIngredient" + num).asText().toLowerCase().equals("maraschino liqueur")) {
                ingredientsAndMeasure.put("Maraschino liqueur", cocktail.findValue("strMeasure" + num).asText());
            } else if (cocktail.findValue("strIngredient" + num).asText().toLowerCase().equals("maraschino cherry")) {
                ingredientsAndMeasure.put("Maraschino cherry", cocktail.findValue("strMeasure" + num).asText());
            } else if (cocktail.findValue("strIngredient" + num).asText().toLowerCase().equals("pineapple juice")) {
                ingredientsAndMeasure.put("Pineapple juice", cocktail.findValue("strMeasure" + num).asText());
            } else if (cocktail.findValue("strIngredient" + num).asText().toLowerCase().equals("rye whiskey")) {
                ingredientsAndMeasure.put("Rye Whiskey", cocktail.findValue("strMeasure" + num).asText());
            } else if (cocktail.findValue("strIngredient" + num).asText().toLowerCase().equals("triple sec")) {
                ingredientsAndMeasure.put("Triple Sec", cocktail.findValue("strMeasure" + num).asText());
            } else if (cocktail.findValue("strIngredient" + num).asText().toLowerCase().equals("white rum")) {
                ingredientsAndMeasure.put("White Rum", cocktail.findValue("strMeasure" + num).asText());
            } else if (cocktail.findValue("strIngredient" + num).asText().toLowerCase().equals("blackstrap rum")) {
                ingredientsAndMeasure.put("Blackstrap Rum", cocktail.findValue("strMeasure" + num).asText());
            } else {
                ingredientsAndMeasure.put(cocktail.findValue("strIngredient" + num).asText(), cocktail.findValue("strMeasure" + num).asText());
            }
        }
        return ingredientsAndMeasure;
    }

    private List<String> getNumbers(JsonNode jsonNode) {
        List<String> numbers = new ArrayList<>();
        for (int i = 1; i < 16; i++) {                      //not nice, but i had to hardcode this magic number, because of the stupid json api
            if (!jsonNode.findValue("strIngredient" + i).asText().equals("null") && !(jsonNode.findValue("strIngredient" + i).asText().equals(""))) {
                numbers.add("" + i);
            }
        }
        return numbers;
    }


}
