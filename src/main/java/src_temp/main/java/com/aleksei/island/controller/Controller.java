package src_temp.main.java.com.aleksei.island.controller;


import com.aleksei.island.entities.Location;
import com.aleksei.island.model.Model;
import com.aleksei.island.view.View;

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
