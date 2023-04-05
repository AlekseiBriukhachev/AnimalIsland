package com.aleksei.animalisland.service;

import com.aleksei.animalisland.model.BaseEntity;
import com.aleksei.animalisland.model.Grass;
import com.aleksei.animalisland.model.Location;

public interface GrassService {
    void create(Grass grass, int locationId);

}
