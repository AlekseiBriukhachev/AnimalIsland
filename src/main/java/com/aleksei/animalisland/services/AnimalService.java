package com.aleksei.animalisland.services;

import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.repositories.Food;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AnimalService<T extends Animal> {

    List<T> feed(List<T> animals);

    Map<Position, Integer> evaluate(T animal, Visibility visibility);

    Optional<Position> move(T animal, Visibility visibility);

    Optional<Food> feed(T animal, Visibility visibility);
}
