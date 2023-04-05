package com.aleksei.animalisland.repository;

import com.aleksei.animalisland.model.BaseEntity;
import com.aleksei.animalisland.model.Location;

import java.util.List;

public interface EntityRepository<T extends BaseEntity> {
    void create(T entity, int locationId);
    List<T> getAllInLocation(int locationId);


}
