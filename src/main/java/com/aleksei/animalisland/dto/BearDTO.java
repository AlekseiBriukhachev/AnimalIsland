package com.aleksei.animalisland.dto;

import com.aleksei.animalisland.model.Animal;
import com.aleksei.animalisland.model.Bear;
import com.aleksei.animalisland.model.Location;

import java.util.Map;

class BearDTO<T extends Bear<T>> extends Animal<T>  {
    public BearDTO() {
    }

    public BearDTO(Location<T> location, double weight, int maxNumberPerLocation, String symbol,
                int speed, double foodQuantity, Map<String, Integer> eatProbability) {
        super(location, weight, maxNumberPerLocation, symbol, speed, foodQuantity, eatProbability);
    }
}
