package com.aleksei.animalisland;


import com.aleksei.animalisland.utils.enumartion.AnimalType;
import com.aleksei.animalisland.utils.factories.AnimalFactory;
import com.aleksei.animalisland.view.MainWindow;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;

@Slf4j
public class Application {
    public static void main(String[] args) {
//        Simulation simulation = new Simulation(100, 20);
//        simulation.run();
//        Model model = new Model();
//        Controller controller = new Controller(model);
//        View view = new View(controller);
//        view.init();

        AnimalFactory animalFactroy = AnimalFactory.getInstance();
        log.debug("Start application");
        System.out.println(animalFactroy.create(AnimalType.BEAR));
        System.out.println(animalFactroy.create(AnimalType.WOLF));
        log.debug("Stop application");


        EventQueue.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow();
//            mainWindow.init();
        });
    }
}
