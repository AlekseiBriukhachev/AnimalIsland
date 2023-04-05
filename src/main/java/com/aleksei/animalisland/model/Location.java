package com.aleksei.animalisland.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Location {
    private Integer id;
    private final List<? extends BaseEntity> entityList = new ArrayList<>();
    public Location(){
        id ++;
    }
}
