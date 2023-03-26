package com.aleksei.animalisland.repository;

import com.aleksei.animalisland.models.animals.Animal;

public interface AnimalRepository {
    void move();
    Animal create(Animal animal);
}
