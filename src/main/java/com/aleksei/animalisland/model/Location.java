package com.aleksei.animalisland.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Location {
    private final List<? extends BaseEntity> entityList = new ArrayList<>();
}
