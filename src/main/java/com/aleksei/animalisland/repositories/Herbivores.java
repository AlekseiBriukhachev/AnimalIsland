package com.aleksei.animalisland.repositories;


public interface Herbivores {
    default void eatPlants(){
        //TODO eat another animal according probability table
        System.out.println("Eat Plants");
    }
}
