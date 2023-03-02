package src_temp.main.java.com.aleksei.island.utils;

import com.aleksei.island.enumartion.AnimalType;

public interface Herbivores {
    default void eatPlants(){
        //TODO eat another animal according probability table
        System.out.println("Eat Plants");
    }
}
