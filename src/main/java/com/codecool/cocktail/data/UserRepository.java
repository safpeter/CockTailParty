package com.codecool.cocktail.data;

import com.codecool.cocktail.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository <AppUser, Long> {

    Optional<AppUser> findByUsername(String username);

    Boolean existsByEmailAndUsername(String email,String username);

    AppUser getAppUserByUsername(String name);

}
