package com.aleksei.animalisland.models;

import com.aleksei.animalisland.repositories.Food;
import com.aleksei.animalisland.repositories.info.AnimalInfo;
import com.aleksei.animalisland.services.Position;
import com.aleksei.animalisland.services.Visibility;

import java.util.Map;
import java.util.Optional;

public interface AI<T extends Animal> {

    Map<Position, Integer> evaluate(T animal, Visibility visibility);

    Optional<Position> move(T animal, Visibility visibility);

    Optional<Food> feed(T animal, Visibility visibility);
}
