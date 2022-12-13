package com.briukhachev.aleksei;


import com.briukhachev.aleksei.model.Location;
import com.briukhachev.aleksei.model.Model;

public class Controller {
    private Model model;
    private View view;
    private boolean isStarted = false;

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
        return model.getSimLocation();
    }
    public void setSimLocation(Location[][] simLocation) {
        model.setSimLocation(simLocation);
    }

    public void startSimulation() {
        isStarted = true;
        model.simulate();
    }

    public boolean isStarted() {
        return isStarted;
    }
}
