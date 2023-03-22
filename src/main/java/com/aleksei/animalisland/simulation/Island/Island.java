package com.aleksei.animalisland.simulation.Island;


import com.aleksei.animalisland.config.AppConfig;
import com.aleksei.animalisland.dao.SimulationResult;
import com.aleksei.animalisland.simulation.Simulation;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Island implements Simulation {
    private static final AppConfig CONFIG = AppConfig.getAppConfig();
    private final int width = CONFIG.getIslandWidth();
    private final int height = CONFIG.getIslandHeight();
    private final Location[][] island = new Location[width][height];
    public Island(){
    }
    private void init(){
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                island[x][y] = new Location();
            }
        }
        addAnimal();
    }

    private void addAnimal() {

    }


    @Override
    public SimulationResult startSimulation(Island island) {
        return null;
    }
}
