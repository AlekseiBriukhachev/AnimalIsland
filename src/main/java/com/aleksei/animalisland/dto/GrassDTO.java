package com.aleksei.animalisland.dto;

import com.aleksei.animalisland.model.BaseEntity;
import com.aleksei.animalisland.model.Location;

class GrassDTO<T extends BaseEntity<T>> extends BaseEntity<T> {
    public GrassDTO() {
    }

    public GrassDTO(Location<T> location, double weight, int maxNumberPerLocation, String symbol) {
        super(location, weight, maxNumberPerLocation, symbol);
    }
}
