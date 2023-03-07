package com.aleksei.animalisland.services.animals;

import com.aleksei.animalisland.config.AppConfig;
import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.models.animals.Bear;
import com.aleksei.animalisland.repositories.Predator;
import com.aleksei.animalisland.services.Position;
import com.aleksei.animalisland.utils.Direction;
import com.aleksei.animalisland.utils.Factories;
import com.aleksei.animalisland.utils.enumartion.AnimalType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BearService implements Predator {
    private final AppConfig CONFIG = AppConfig.getAppConfig();
    private final List<Bear> bears;
    {
        bears = IntStream.range(0, CONFIG.getInitNumber(Bear.class))
                .mapToObj(i -> (Bear) Factories.getInstance().create(AnimalType.BEAR))
                .toList();
    }
    public List<Bear> breed(){

            bears.add((Bear) Factories.getInstance().create(AnimalType.BEAR));
        return bears;

    }
    public int getAllBears(){
        return bears.size();
    }
    public void move(){
        for (Bear bear : bears){
            int newX = bear.getPosition().x() + ThreadLocalRandom.current().nextInt(CONFIG.getSpeed(AnimalType.BEAR) - 1);
            int newY = bear.getPosition().y() + ThreadLocalRandom.current().nextInt(CONFIG.getSpeed(AnimalType.BEAR) - 1);

            if (newX >= 0 && newX < CONFIG.getIslandWidth() && newY >= 0 && newY < CONFIG.getIslandHeight()){
                bear.setPosition(new Position(newX, newY));
            }

        }
    }

    public List<? extends Animal<?>> eat(List<? extends Animal<?>> animals) {
        int eatProbability = Integer.parseInt(CONFIG.getEatingProbability(Bear.class).stream()
                .filter(s -> animals.getClass().getSimpleName().equals(s))
                .findFirst()
                .get());
        synchronized (animals){
            if (animals.size() > 1){
                Animal otherAnimal = animals.get(ThreadLocalRandom.current().nextInt(animals.size()));
                if (ThreadLocalRandom.current().nextInt() <= eatProbability){
                    animals.remove(otherAnimal);
                }
            }
        }
        return animals;
    }

}
