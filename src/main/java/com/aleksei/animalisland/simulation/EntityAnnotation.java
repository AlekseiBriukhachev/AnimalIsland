package com.aleksei.animalisland.simulation;

import java.lang.annotation.*;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Inherited
public @interface EntityAnnotation {
    String name();
    String symbol();
    double weight();
    int speed();
    double foodAmount();
    int maxNumberPerLocation();

    //Eating probability [] = {Wolf, Snake, Fox, Bear, Eagle, Horse, Deer, Rabbit, Mouse, Goat, Sheep, Boar, Buffalo, Duck, Caterpillar, Grass}
    int[] eatProbability();

}
