package com.aleksei.animalisland.service;

import com.aleksei.animalisland.model.Bear;
import com.aleksei.animalisland.model.Location;

public interface BearService {
    void create(Bear bear, int locationId);
}
