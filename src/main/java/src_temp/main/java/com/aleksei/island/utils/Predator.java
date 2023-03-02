package src_temp.main.java.com.aleksei.island.utils;

import com.aleksei.island.enumartion.AnimalType;

public interface Predator {
    default void eatAnimal(AnimalType type){
        //TODO eat another animal according probability table
        System.out.println("Eat animals");
    }
}
