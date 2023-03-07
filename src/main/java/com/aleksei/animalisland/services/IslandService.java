package com.aleksei.animalisland.services;

import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.services.animals.*;
import com.aleksei.animalisland.models.Location;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Data
public class IslandService {
    private final int width;
    private final int height;
    private final List<Location> locations;
    private BearService bearService;
    private BoarService boarService;
    private BuffaloService buffaloService;
    private CaterpillarService caterpillarService;
    private DeerService deerService;
    private DuckService duckService;
    private EagleService eagleService;
    private FoxService foxService;
    private GoatService goatService;
    private HorseService horseService;
    private MouseService mouseService;
    private RabbitService rabbitService;
    private SheepService sheepService;
    private SnakeService snakeService;
    private WolfService wolfService;

//    public IslandVisibility visibilityFor(Animal<?> animal) {
//        return new IslandVisibility(
//                getWidth(),
//                getHeight(),
//                Stream.concat(bearService.bearStream(),
//                                Stream.concat(boarService.boarStream(),
//                                        Stream.concat(buffaloService.buffaloStream(),
//                                                Stream.concat(caterpillarService.caterpillarStream(),
//                                                        Stream.concat(deerService.deerStream(),
//                                                                Stream.concat(duckService.duckStream(),
//                                                                        Stream.concat(eagleService.eagleStream(),
//                                                                                Stream.concat(foxService.foxStream(),
//                                                                                        Stream.concat(goatService.goatStream(),
//                                                                                                Stream.concat(horseService.horseStream(),
//                                                                                                        Stream.concat(mouseService.mouseStream(),
//                                                                                                                Stream.concat(rabbitService.rabbitStream(),
//                                                                                                                        Stream.concat(sheepService.sheepStream(),
//                                                                                                                                Stream.concat(snakeService.snakeStream(), wolfService.wolfStream()))))))))))))))
//                        .filter(animalUnit -> animalUnit != animal)
//                        .filter(animalUnit -> animalUnit.getPosition().getDistance(animalUnit.getPosition()) <= animalUnit.getSight())
//                        .collect(Collectors.toList()),
//                animal.getPosition()
//                        .lookAround(animal.getSight(), this)
//                        .stream()
//                        .map(this::onLocation)
//                        .collect(Collectors.toSet())
//        );
//
//    }

    private Location onLocation(Position position) {
        return locations.get(position.x() + width * position.y());
    }
}
