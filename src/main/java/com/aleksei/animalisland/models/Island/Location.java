package com.aleksei.animalisland.models.Island;


import com.aleksei.animalisland.models.animal.Animal;
import com.aleksei.animalisland.models.plant.Plant;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Location {
    private final List<Animal> animals = new ArrayList<>();
    private final List<Plant> plants = new ArrayList<>();
}
