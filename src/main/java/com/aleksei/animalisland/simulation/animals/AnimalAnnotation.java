package com.aleksei.animalisland.simulation.animals;

import java.lang.annotation.*;
import java.util.List;
import java.util.Map;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Inherited
public @interface AnimalAnnotation {
    String name();
    String symbol();
    double weight();
    int speed();
    double foodAmount();
    int maxNumberPerLocation();

    //Eating probability [] = {Wolf, Snake, Fox, Bear, Eagle, Horse, Deer, Rabbit, Mouse, Goat, Sheep, Boar, Buffalo, Duck, Caterpillar, Grass}
    int[] eatProbability();

}
