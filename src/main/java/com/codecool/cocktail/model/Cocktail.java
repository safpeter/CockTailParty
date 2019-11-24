package com.codecool.cocktail.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Map;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cocktail {

    @Id
    @GeneratedValue
    private Long ID;

    @Column(nullable = false)
    private String name;

    private String type;

    private String category;

    @Enumerated(value = EnumType.STRING)
    private AlcoholContent alcoholContent;

    private String glassType;

    @Column(nullable = false, columnDefinition = "text")
    private String recipe;

    private String pictureURL;


    @ElementCollection
    @CollectionTable(name = "INGREDIENTS")
    @MapKeyColumn(name="ingredient_key")
    @Column(name="quantity", nullable = false)
    private Map<String, String> ingredients;
}
