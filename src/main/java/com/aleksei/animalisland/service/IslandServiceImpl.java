package com.aleksei.animalisland.service;


import com.aleksei.animalisland.config.AppConfig;
import com.aleksei.animalisland.model.Bear;
import com.aleksei.animalisland.model.Grass;
import com.aleksei.animalisland.model.Location;
import com.aleksei.animalisland.model.Rabbit;
import com.aleksei.animalisland.utils.UnknownAnimalException;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Slf4j
public class IslandServiceImpl implements IslandService {
    private static final AppConfig CONFIG = AppConfig.getAppConfig();
    private final int width = CONFIG.getIslandWidth();
    private final int height = CONFIG.getIslandHeight();
    private final BearService bearService = new BearServiceImpl();
    private final RabbitService rabbitService = new RabbitServiceImpl();
    private final GrassService grassService = new GrassServiceImpl();
    private final Location[][] island = new Location[width][height];

    @Override
    public void init() {
        Location location = new Location();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                log.debug("Create location with axis x = {} ana Y = {}", x, y);
                island[x][y] = location;
                int id = location.getId();
                id++;
                location.setId(id);
                addEntityToLocation(location);

            }
        }
    }

    private void addEntityToLocation(Location location) {
        for (String entityString : AppConfig.getEntityList()) {
            //TODO create entities according maxNumberPerLocation
            int maxNumberPerLocation = ThreadLocalRandom.current().nextInt(CONFIG.getMaxNumberPerLocation(entityString));
            IntStream.rangeClosed(0, maxNumberPerLocation)
                            .forEachOrdered(i -> checkAndCreateEntity(entityString, location.getId()));
        }
    }

    private void checkAndCreateEntity(String entityString, int locationId) {
        switch (entityString) {
            case "bear" -> bearService.create(new Bear(), locationId);
            case "rabbit" -> rabbitService.create(new Rabbit(), locationId);
            case "grass" -> grassService.create(new Grass(), locationId);
            default -> throw new UnknownAnimalException("Unknown entity: " + entityString);
        }
    }
}
