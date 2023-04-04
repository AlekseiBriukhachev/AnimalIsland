package com.aleksei.animalisland.model;

import lombok.Data;
@Data
public abstract class BaseEntity {
    private Location location;
    private double weight;
    private int maxNumberPerLocation;
    private String symbol;
    public BaseEntity(){
    }

    public BaseEntity(Location location, double weight, int maxNumberPerLocation, String symbol) {
        this.location = location;
        this.weight = weight;
        this.maxNumberPerLocation = maxNumberPerLocation;
        this.symbol = symbol;
    }
}
