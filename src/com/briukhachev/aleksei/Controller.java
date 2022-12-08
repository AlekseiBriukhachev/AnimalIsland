package com.briukhachev.aleksei;


import com.briukhachev.aleksei.model.Model;

public class Controller {
    private Model model;
    private View view;

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
}
