package com.aleksei.animalisland.repository;



import com.aleksei.animalisland.models.Island.Location;
import com.aleksei.animalisland.models.animals.Animal;

import java.util.Optional;

public interface AnimalService<T extends AnimalInfo> {

    void feed(Location location);

//    Map<Position, Integer> evaluate(T animal, Visibility visibility);
//

//    Optional<Position> move(T animal, Visibility visibility);
}
