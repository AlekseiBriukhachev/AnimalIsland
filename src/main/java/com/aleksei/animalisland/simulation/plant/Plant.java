package com.aleksei.animalisland.simulation.plant;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class Plant {
    private String name;
    private String symbol;
    private double weight;
}
