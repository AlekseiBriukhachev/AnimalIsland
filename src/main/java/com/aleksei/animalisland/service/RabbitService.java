package com.aleksei.animalisland.service;

import com.aleksei.animalisland.model.Location;
import com.aleksei.animalisland.model.Rabbit;

public interface RabbitService {
    Rabbit create(Location location, Rabbit rabbit);
}
