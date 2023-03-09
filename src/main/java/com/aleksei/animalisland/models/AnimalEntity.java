package com.aleksei.animalisland.models;

import com.aleksei.animalisland.repositories.Food;
import com.aleksei.animalisland.services.Position;
import com.aleksei.animalisland.services.Visibility;

import java.util.Map;
import java.util.Optional;

public interface AnimalEntity {
    Map<Position, Integer> evaluate(Visibility visibility);

    Optional<Position> move(Visibility visibility);

    Optional<Food> feed(Visibility visibility);

    void breed(Visibility visibility);
}
