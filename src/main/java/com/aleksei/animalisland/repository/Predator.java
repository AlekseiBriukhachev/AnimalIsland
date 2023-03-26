package com.aleksei.animalisland.repository;

import com.aleksei.animalisland.models.animals.Animal;

public interface Predator extends AnimalRepository {
    void eatOtherAnimal(Animal animal);
}
