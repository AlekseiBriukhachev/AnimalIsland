package com.aleksei.animalisland.repositories;

import com.aleksei.animalisland.services.Position;
import com.aleksei.animalisland.utils.info.AnimalInfo;

import java.util.Map;
import java.util.Optional;

public interface Info<T extends AnimalInfo> {
    Map<Position, Integer> evaluate(T animal, Visibility visibility);
    Optional<Position> move(T animal, Visibility visibility);
    Optional<Food> feed(T animal, Visibility visibility);
}
