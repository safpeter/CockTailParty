package com.codecool.cocktail.data;

import com.codecool.cocktail.model.Cocktail;
import com.codecool.cocktail.model.CocktailParts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface CocktailRepository extends JpaRepository<Cocktail, Long> {


//    @Query("SELECT new com.codecool.cocktail.model.CocktailParts(c.id,c.name) from Cocktail c")
//    Set<CocktailParts> getAllCocktailNames();

    @Query("SELECT c.name from Cocktail c")
    Set<String> getAllCocktailNames();

    @Query("SELECT new com.codecool.cocktail.model.CocktailParts(c.name, c.pictureURL) from Cocktail c")
    Set<CocktailParts> getAllCocktailNamesAndPictures();


    Cocktail getCocktailByName(String name);


    @Query(value = "select c from Cocktail c\n")
    Set<Cocktail> getAllCocktailes();


    @Query("select c.id  from Cocktail c WHERE c.name LIKE :name")
    Long getIdByName(@Param("name") String name);




}
