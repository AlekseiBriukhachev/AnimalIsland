package com.aleksei.animalisland.utils;

import com.aleksei.animalisland.repositories.gauge.AnimalGauge;

public class Scent {
    private final AnimalGauge power = new AnimalGauge(5, 0, 5);
    public void update(){
        power.minus(1);
    }
    public void restore(){
        power.setCurrent(power.getMax());
    }
    public Integer getCurrent(){
        return power.getCurrent();
    }
    @Override
    public String toString(){
        return "Scent{" + power + "}";
    }
}
