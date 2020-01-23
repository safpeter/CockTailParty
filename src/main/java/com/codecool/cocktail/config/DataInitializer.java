package com.codecool.cocktail.config;

import com.codecool.cocktail.CocktailApplication;
import com.codecool.cocktail.config.CocktailRoutes;
import com.codecool.cocktail.data.CocktailRepository;
import com.codecool.cocktail.data.UserRepository;
import com.codecool.cocktail.model.AppUser;
import com.codecool.cocktail.service.IngredientsMaker;
import com.codecool.cocktail.service.JsonCocktailsToRealCocktail;
import com.codecool.cocktail.service.JsonObjectMaker;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    CocktailRoutes cocktailRoutes;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    JsonObjectMaker jsonObjectMaker;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    JsonCocktailsToRealCocktail jsonCocktailsToRealCocktail;

    @Autowired
    CocktailRepository cocktailRepository;

    @Autowired
    AppUser appUser;

    @Autowired
    UserRepository userRepository;

    @Autowired
    IngredientsMaker ingredientsMaker;

    private final PasswordEncoder passwordEncoder;

    public DataInitializer() {
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        ;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(CocktailApplication.class);


    @Override
    public void run(String... args) throws Exception {
        //
        if (userRepository.existsByEmailAndUsername("admin@codecool.com", "admin")) {
            LOGGER.info("Nothing to update");
        } else {
            userRepository.save(AppUser.builder()
                    .email("admin@codecool.com")
                    .username("admin")
                    .roles(Arrays.asList("Admin", "User"))
                    .password(passwordEncoder.encode("password"))
                    .build());
            for (String route : cocktailRoutes.getCocktailURLs()) {
                List<JsonNode> jsnodeCock = jsonObjectMaker.getJsonCocktailsFromUrl(route, restTemplate, objectMapper);
                if (jsnodeCock != null) {
                    cocktailRepository.saveAll(jsonCocktailsToRealCocktail
                            .createCocktails(jsnodeCock));
                }
                if (jsnodeCock != null) {
                    jsnodeCock.clear();
                }
                LOGGER.info("Cocktails Saved!");
            }

            LOGGER.info("ready");
        }
    }
}
