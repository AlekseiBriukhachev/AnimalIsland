package com.aleksei.animalisland.services;

import com.aleksei.animalisland.models.Island.Location;
import com.aleksei.animalisland.utils.factories.CellFactory;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

@RequiredArgsConstructor
class AnimalServiceTest {
    private final CellFactory cellFactory = new CellFactory();
    private final Location location = cellFactory.createCell();

    @Test
    void animalEat() {

        AnimalService animalService = new AnimalService();

        animalService.animalEat(location);




    }
}