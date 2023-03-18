package com.aleksei.animalisland.repository;



import com.aleksei.animalisland.models.Island.Location;
import com.aleksei.animalisland.models.animals.Animal;

import java.util.Optional;

public interface AnimalService<T extends Animal> extends AnimalInfo {

//    List<T> feed(List<T> animals);

//    Map<Position, Integer> evaluate(T animal, Visibility visibility);
//
//    Optional<Position> move(T animal, Visibility visibility);

    void feed(Location location, T info);
}
