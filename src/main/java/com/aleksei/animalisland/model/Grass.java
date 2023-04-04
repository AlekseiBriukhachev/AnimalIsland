package com.aleksei.animalisland.model;

public class Grass extends BaseEntity {
    public Grass(){
    }

    public Grass(Location location, double weight, int maxNumberPerLocation, String symbol) {
        super(location, weight, maxNumberPerLocation, symbol);
    }
}
