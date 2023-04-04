package com.aleksei.animalisland.repository;

import com.aleksei.animalisland.model.BaseEntity;

public interface AnimalRepository<T extends BaseEntity> extends EntityRepository<T> {
    void move();
    void reproduce();

}
