package src_temp.main.java.com.aleksei.island.service;

import com.aleksei.island.entities.Animal;
import com.aleksei.island.entities.Location;
import com.aleksei.island.entities.Plant;

import java.util.ArrayList;
import java.util.List;

public class Island {
    private Location[][] locations;
    private List<Animal> animals;
    private List<Plant> plants;

    public Island(int width, int height) {
        locations = new Location[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                locations[x][y] = new Location(x, y);
            }
        }
        animals = new ArrayList<>();
        plants = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void simulate() {
        for (Animal animal : animals) {
            if (!animal.isAlive()) {
                continue;
            }

            Location location = animal.getLocation();

            // TODO: implement logic for eating, moving, reproducing, and dying
        }
    }

}
