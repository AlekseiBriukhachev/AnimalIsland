package com.aleksei.animalisland.models.animals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class EntityAI implements Cloneable {
    private String name;
    private String symbol;
    private double weight;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return symbol;
    }
}
