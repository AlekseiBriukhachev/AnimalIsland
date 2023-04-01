package com.aleksei.animalisland.models.Island;


import com.aleksei.animalisland.config.BaseConfig;
import com.aleksei.animalisland.models.animals.Animal;
import com.aleksei.animalisland.models.animals.Bear;
import com.aleksei.animalisland.models.plant.Plant;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Location {
    private final BaseConfig CONFIG = BaseConfig.getAppConfig();

    private final List<Animal> animals = new ArrayList<>();
    private final List<Plant> plants = new ArrayList<>();

//    public boolean isNotFull() {
//        if (animals.contains(Bear.class)){
//
//        }
//        for (Animal animal : animals){
//
//        }
//        return animals.isEmpty() && plants.size() > CONFIG.get;
//    }
}
