package com.codecool.cocktail;

import com.codecool.cocktail.service.IngredientsMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class CocktailApplication {

    public static void main(String[] args) {
        SpringApplication.run(CocktailApplication.class, args);
    }


}
