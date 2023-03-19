package com.aleksei.animalisland.utils;


import com.aleksei.animalisland.models.Scent;
import com.aleksei.animalisland.services.Position;

public interface ScentStorage {

    Scent get(Position position);

    void update(Position position);
}
