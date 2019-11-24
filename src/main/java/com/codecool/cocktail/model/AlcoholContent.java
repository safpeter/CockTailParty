package com.codecool.cocktail.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
public enum AlcoholContent {

    ALCOHOLIC("Alcoholic"), ALCOHOLFREE("Non alcoholic"), OPTIONAL("Optional alcohol"), DONNO(null);

    private  String label;


    public static AlcoholContent getEnumAlcoholFromString(String text){
        switch(text) {
            case "Alcoholic":
                // code block
                return ALCOHOLIC;

            case "Non alcoholic":
                return ALCOHOLFREE;

            case "Optional alcohol":
                return OPTIONAL;
            default:
                return DONNO;
        }
    }

    public static List<String> alcoholList(){
        return Arrays.asList("ALCOHOLIC", "NONALCOHOLIC", "OPTIONAL", "DONNO");
    }


}
