package com.briukhachev.aleksei.model;


import com.briukhachev.aleksei.Location;
import com.briukhachev.aleksei.Params;
import com.briukhachev.aleksei.animalplant.Animal;
import com.briukhachev.aleksei.animals.Wolf;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Model {
    private Params params = new Params();
    private Location[][] simLocation = new Location[params.getWidth()][params.getHeight()];
    public Model(){
        createSimLocations();
    }

    private void createSimLocations() {
        for (int x = 0; x < params.getWidth(); x++) {
            for (int y = 0; y < params.getHeight(); y++) {
                simLocation[x][y] = new Location();
            }
        }
    }

    public Location[][] getSimLocation() {
        return simLocation;
    }

    public void setSimLocation(Location[][] simLocation) {
        this.simLocation = simLocation;
    }

    public void simulate() {
        ScheduledExecutorService scheduleSimCycle = Executors.newScheduledThreadPool(5);
        scheduleSimCycle.scheduleAtFixedRate(new Cycle(), 0, 500, TimeUnit.MILLISECONDS);
    }
}
