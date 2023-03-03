package com.aleksei.animalisland.repositories.gauge;

public class AnimalGauge extends Gauge<Integer> implements AnimalGaugeInfo {
    public AnimalGauge(Integer current, Integer min, Integer max){
        super(current, min, max);
    }
    public AnimalGauge(Integer min, Integer max){
        super(max, min, max);
    }
    @Override
    public double part() {
        return getCurrent().doubleValue() / getMax().doubleValue();
    }
    public void plus(int delta){
        setCurrent(getCurrent() + delta);
    }
    public void minus(int delta){
        setCurrent(getCurrent() - delta);
    }
    @Override
    public String toString(){
        return String.format("%d/%d", getCurrent(), getMax());
    }
}
