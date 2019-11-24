package com.codecool.cocktail.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;


@Service
public class JsonObjectMaker {


    public List<JsonNode> getJsonCocktailsFromUrl(String path, RestTemplate restTemplate, ObjectMapper mapper) throws IOException {
        List<JsonNode> cocktails = new ArrayList<>();
        ResponseEntity<String> response = restTemplate.getForEntity(path, String.class);
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode drinks = root.findValue("drinks");
        if (!drinks.isNull()) {
            for (JsonNode drink : drinks) {
                cocktails.add(drink);
            }
            return cocktails;
        }
        return null;
    }
}
