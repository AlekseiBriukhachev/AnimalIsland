package com.aleksei.animalisland.repositories;

import com.aleksei.animalisland.models.Location;
import com.aleksei.animalisland.services.Position;
import com.aleksei.animalisland.utils.Sized;
import com.aleksei.animalisland.utils.info.AnimalInfo;

import java.util.stream.Stream;

public interface Visibility extends Sized {
    int getWidth();
    int getHeight();
    Stream<? extends AnimalInfo> animals();

    Stream<Location> locations();

    Visibility local(Position position);
}
