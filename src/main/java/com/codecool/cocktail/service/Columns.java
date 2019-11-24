package com.codecool.cocktail.service;

import javax.persistence.Column;

public @interface Columns {
    Column[] value();
}