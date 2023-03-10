package com.aleksei.animalisland.models;

import com.aleksei.animalisland.models.animals.Bear;

import java.util.List;

public interface AnimalEntity {
//    Map<Position, Integer> evaluate(Visibility visibility);

    void move();

    List<? extends Animal<?>> feed(List<? extends Animal<?>> animals);

//    List<? extends Animal<?>> breed();
}
