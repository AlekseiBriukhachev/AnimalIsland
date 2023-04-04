package com.aleksei.animalisland.model;

import java.util.Map;

public class Bear extends Animal {
    public Bear() {
    }

    public Bear(Location location, double weight, int maxNumberPerLocation, String symbol,
                int speed, double foodQuantity, Map<String, Integer> eatProbability) {
        super(location, weight, maxNumberPerLocation, symbol, speed, foodQuantity, eatProbability);
    }
}
