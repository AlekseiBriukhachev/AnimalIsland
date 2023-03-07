package com.aleksei.animalisland.services.animals;

import com.aleksei.animalisland.config.AppConfig;
import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.models.animals.Bear;
import com.aleksei.animalisland.models.animals.Boar;
import com.aleksei.animalisland.services.Position;
import com.aleksei.animalisland.utils.factories.AnimalFactory;
import com.aleksei.animalisland.utils.enumartion.AnimalType;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static com.aleksei.animalisland.utils.Utils.getAnimals;

public class BoarService {
    private final AppConfig CONFIG = AppConfig.getAppConfig();
    private final List<Boar> boars;
    {
        boars = IntStream.range(0, CONFIG.getInitNumber(Bear.class))
                .mapToObj(i -> (Boar) AnimalFactory.getInstance().create(AnimalType.BOAR))
                .toList();
    }
    public List<Boar> breed(){

        boars.add((Boar) AnimalFactory.getInstance().create(AnimalType.BOAR));
        return boars;

    }
    public int getAllBoars(){
        return boars.size();
    }
    public void move(){
        for (Boar boar : boars){
            int newX = boar.getPosition().x() + ThreadLocalRandom.current().nextInt(CONFIG.getSpeed(AnimalType.BOAR) - 1);
            int newY = boar.getPosition().y() + ThreadLocalRandom.current().nextInt(CONFIG.getSpeed(AnimalType.BOAR) - 1);

            if (newX >= 0 && newX < CONFIG.getIslandWidth() && newY >= 0 && newY < CONFIG.getIslandHeight()){
                boar.setPosition(new Position(newX, newY));
            }

        }
    }

    public List<? extends Animal<?>> eat(List<? extends Animal<?>> animals) {
        int eatProbability = Integer.parseInt(CONFIG.getEatingProbability(Boar.class).stream()
                .filter(s -> animals.getClass().getSimpleName().equals(s))
                .findFirst()
                .get());
        return getAnimals(animals, eatProbability);
    }
}
