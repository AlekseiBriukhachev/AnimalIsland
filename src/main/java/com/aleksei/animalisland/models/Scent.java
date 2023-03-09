package com.aleksei.animalisland.models;


import com.aleksei.animalisland.utils.stats.NumberGauge;

public class Scent {

    private final NumberGauge power = new NumberGauge(5, 0, 5);

    public void update() {
        power.minus(1);
    }

    public void restore() {
        power.setCurrent(power.getMax());
    }

    public Integer get() {
        return power.getCurrent();
    }

    @Override
    public String toString() {
        return "Scent{" + power + '}';
    }
}
