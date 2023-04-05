package com.aleksei.animalisland.dto;

import com.aleksei.animalisland.model.BaseEntity;
import com.aleksei.animalisland.model.Location;

class GrassDTO extends BaseEntity {
    public GrassDTO() {
    }

    public GrassDTO(Location location, double weight, int maxNumberPerLocation, String symbol) {
        super(location, weight, maxNumberPerLocation, symbol);
    }
}
