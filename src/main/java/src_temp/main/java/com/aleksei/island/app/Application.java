package src_temp.main.java.com.aleksei.island.app;

import com.aleksei.island.controller.Controller;
import com.aleksei.island.enumartion.AnimalType;
import com.aleksei.island.model.Model;
import com.aleksei.island.service.Factories;
import com.aleksei.island.view.View;
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
