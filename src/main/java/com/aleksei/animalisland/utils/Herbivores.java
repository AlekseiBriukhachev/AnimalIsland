package com.aleksei.animalisland.utils;


public interface Herbivores {
    default void eatPlants(){
        //TODO eat another animal according probability table
        System.out.println("Eat Plants");
    }
}
