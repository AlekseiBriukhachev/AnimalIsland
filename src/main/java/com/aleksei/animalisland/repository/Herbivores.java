package com.aleksei.animalisland.repository;

import com.aleksei.animalisland.model.BaseEntity;

public interface Herbivores<T extends BaseEntity> extends AnimalRepository<T> {
    void eatGrass();
}
