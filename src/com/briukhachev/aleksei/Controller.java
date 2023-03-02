package com.briukhachev.aleksei;


import com.briukhachev.aleksei.animalfactory.IslandFactory;
import com.briukhachev.aleksei.model.Location;
import com.briukhachev.aleksei.model.Model;
import com.briukhachev.aleksei.service.Params;

public class Controller {
    private Model model;
    private View view;
    private boolean isStarted = false;
    private static final IslandFactory factory = new IslandFactory();

    public Controller(Model model) {
        this.model = model;
        view = new View(this);
    }

    public Model getModel() {
        return model;
    }

    public View getView() {
        return view;
    }
    public Location[][] getSimLocations(){
//        return model.getSimLocation();
        return null;
    }
//    public void setSimLocation(Location[][] simLocation) {
//        model.setSimLocation(simLocation);
//    }

    public void startSimulation() {
        isStarted = true;
//        model.simulate();
        model.createNew(factory);
    }

    public boolean isStarted() {
        return isStarted;
    }
}
