package com.aleksei.animalisland.services;


import com.aleksei.animalisland.models.Location;
import com.aleksei.animalisland.repositories.info.AnimalInfo;
import com.aleksei.animalisland.utils.Sized;

import java.util.stream.Stream;

public interface Visibility extends Sized {

    int getWidth();

    int getHeight();

    Stream<? extends AnimalInfo> animals();

    Stream<Location> locations();

    Visibility local(Position p);
}
