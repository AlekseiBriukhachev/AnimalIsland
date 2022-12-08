package com.briukhachev.aleksei;


import com.briukhachev.aleksei.animalplant.Animal;
import com.briukhachev.aleksei.animals.Wolf;
import com.briukhachev.aleksei.model.Model;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        View view = new View(controller);
        view.init();

    }
}
