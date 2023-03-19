package com.aleksei.animalisland.services;


import com.aleksei.animalisland.controllers.IslandController;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StartService implements Runnable {
    private final ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
    private final IslandController islandController = new IslandController();

    @Override
    public void run() {
        islandController.printInitialIsland();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        service.scheduleAtFixedRate(islandController::animalEat, 0, 3, TimeUnit.SECONDS);
//        service.scheduleAtFixedRate(islandController::grassGrow, 3, 12, TimeUnit.SECONDS);
//        service.scheduleAtFixedRate(islandController::animalMove, 6, 15, TimeUnit.SECONDS);
//        service.scheduleAtFixedRate(islandController::animalReproduction, 9, 18, TimeUnit.SECONDS);
    }
}
