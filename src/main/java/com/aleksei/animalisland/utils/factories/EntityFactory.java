package com.aleksei.animalisland.utils.factories;


import com.aleksei.animalisland.models.Island.Location;
import com.aleksei.animalisland.models.animals.EntityAI;

public interface EntityFactory<T extends EntityAI> {

    T create(Location location);
}
