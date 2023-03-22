package com.aleksei.animalisland.simulation.Island;


import com.aleksei.animalisland.simulation.animals.*;
import com.aleksei.animalisland.simulation.plant.Plant;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Location {
    private final List<Animal> animals = new ArrayList<>();
    private final List<Plant> plants = new ArrayList<>();
}
