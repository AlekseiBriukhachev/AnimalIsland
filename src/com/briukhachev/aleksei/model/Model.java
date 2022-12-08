package com.briukhachev.aleksei.model;


import com.briukhachev.aleksei.Location;
import com.briukhachev.aleksei.Params;
import com.briukhachev.aleksei.animalplant.Animal;
import com.briukhachev.aleksei.animals.Wolf;

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

}
