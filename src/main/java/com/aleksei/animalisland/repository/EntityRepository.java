package com.aleksei.animalisland.repository;

import com.aleksei.animalisland.model.BaseEntity;
import com.aleksei.animalisland.model.Location;
import com.aleksei.animalisland.old.models.animals.Bear;

import java.util.List;

public interface EntityRepository<T extends BaseEntity> {
    T create(Location location, T entity);
    List<T> getAllInLocation(Location location);


}
