package com.aleksei.animalisland.repositories;

import com.aleksei.animalisland.utils.enumartion.AnimalType;

public interface Predator {
    default void eatAnimal(AnimalType type){
        //TODO eat another animal according probability table
        System.out.println("Eat animals");
    }
}
