package com.aleksei.animalisland.utils;

import com.aleksei.animalisland.repositories.gauge.AnimalGauge;

import java.util.function.Consumer;

public class Pregnancy {
    private final AnimalGauge pregnancyCounter;
    public Pregnancy(Integer waitTime){
        this.pregnancyCounter = new AnimalGauge(0, 0, waitTime);
    }
    public boolean incAnimal(Consumer<AnimalGauge> birth){
        pregnancyCounter.plus(1);
        if (pregnancyCounter.atMax()){
            birth.accept(pregnancyCounter);
            return true;
        }
        return false;
    }
    @Override
    public String toString(){
        return pregnancyCounter.toString();
    }
}
