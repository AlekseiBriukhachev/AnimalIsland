package com.aleksei.animalisland.dto;

import com.aleksei.animalisland.model.Animal;
import com.aleksei.animalisland.model.Location;

import java.util.Map;

public class RabbitDTO extends Animal {
    public RabbitDTO() {
    }

    public RabbitDTO(Location location, double weight, int maxNumberPerLocation, String symbol,
                  int speed, double foodQuantity, Map<String, Integer> eatProbability) {
        super(location, weight, maxNumberPerLocation, symbol, speed, foodQuantity, eatProbability);
    }
}
