package com.aleksei.animalisland.repositories;

import com.aleksei.animalisland.services.Position;
import com.aleksei.animalisland.utils.Scent;

public interface ScentStorage {
    Scent getCurrent(Position position);

    void update(Position position);
}
