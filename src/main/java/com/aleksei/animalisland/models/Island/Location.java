package com.aleksei.animalisland.models.Island;


import com.aleksei.animalisland.models.animals.Animal;
import com.aleksei.animalisland.models.plant.Grass;
import com.aleksei.animalisland.models.plant.Plant;
import com.aleksei.animalisland.utils.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Location {
    private final List<Animal> animals = new ArrayList<>();
    private final List<Plant> plants = new ArrayList<>();
    private final Position position;
    private final Grass grass;
}
