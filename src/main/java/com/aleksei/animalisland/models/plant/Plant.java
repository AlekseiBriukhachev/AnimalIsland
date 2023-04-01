package com.aleksei.animalisland.models.plant;


import com.aleksei.animalisland.models.animals.EntityAI;
import lombok.Data;

@Data
public abstract class Plant extends EntityAI {
    private Integer id;
    public Plant(String name, String symbol, float weight) {
        super(name, symbol, weight);
    }

    public boolean isNew() {
        return id == null;
    }
}
