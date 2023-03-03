package com.aleksei.animalisland.app;


import com.aleksei.animalisland.utils.enumartion.AnimalType;
import com.aleksei.animalisland.service.Factories;
import org.apache.log4j.Logger;

public class Application {
    private static final Logger log = Logger.getLogger(Application.class);
    public static void main(String[] args) {
//        Simulation simulation = new Simulation(100, 20);
//        simulation.run();
//        Model model = new Model();
//        Controller controller = new Controller(model);
//        View view = new View(controller);
//        view.init();

        Factories animalFactroy = new Factories();
        log.info("Start application");
        System.out.println(animalFactroy.create(AnimalType.BEAR));
        System.out.println(animalFactroy.create(AnimalType.WOLF));
        log.info("Stop application");
    }
}
