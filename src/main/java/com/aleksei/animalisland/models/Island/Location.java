package com.aleksei.animalisland.models.Island;


import com.aleksei.animalisland.models.animals.*;
import com.aleksei.animalisland.models.plant.Plant;
import com.aleksei.animalisland.services.Food;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Location {
    private final List<Animal> animals = new ArrayList<>();
    private final List<Bear> bears = new ArrayList<>();
    private final List<Boar> boars = new ArrayList<>();
    private final List<Rabbit> rabbits = new ArrayList<>();
    private final List<Wolf> wolves = new ArrayList<>();
    private final List<Plant> plants = new ArrayList<>();
    private final List<Food> foods = new ArrayList<>();
}
