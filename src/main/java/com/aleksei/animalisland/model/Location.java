package com.aleksei.animalisland.model;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Location {
    private int id;
    private final List<? extends BaseEntity> entityList = new ArrayList<>();

    public Location() {
    }
}
