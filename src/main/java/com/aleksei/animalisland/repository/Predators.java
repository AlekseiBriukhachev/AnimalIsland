package com.aleksei.animalisland.repository;

import com.aleksei.animalisland.model.BaseEntity;

public interface Predators<T extends BaseEntity> extends AnimalRepository<T> {
    void eatOtherAnimal();
}
