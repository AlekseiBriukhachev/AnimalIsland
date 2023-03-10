package com.aleksei.animalisland.services.animals;

import com.aleksei.animalisland.config.AppConfig;
import com.aleksei.animalisland.controller.IslandController;
import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.models.AnimalEntity;
import com.aleksei.animalisland.models.animals.Bear;
import com.aleksei.animalisland.repositories.info.AnimalInfo;
import com.aleksei.animalisland.services.Position;
import com.aleksei.animalisland.services.Visibility;
import com.aleksei.animalisland.utils.Gender;
import com.aleksei.animalisland.utils.enumartion.AnimalType;
import com.aleksei.animalisland.utils.factories.AnimalFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static com.aleksei.animalisland.utils.Utils.getAnimals;

@Slf4j
public final class BearService implements AnimalEntity, AnimalInfo {
    private IslandController controller;
    private final AppConfig CONFIG = AppConfig.getAppConfig();
    protected Gender gender;
    private final List<Bear> bears;

    {
        bears = IntStream.range(0, CONFIG.getInitNumber(Bear.class))
                .mapToObj(i -> (Bear) AnimalFactory.getInstance().create(AnimalType.BEAR))
                .toList();
    }

    @Override
    public Gender gender() {
        return gender;
    }


    //    @Override
//    public Map<Position, Integer> evaluate() {
//        return controller.evaluateBear(bears);
//    }
    @Override
    public void move() {
        for (Bear bear : bears) {
            int newX = bear.getPosition().getX() + ThreadLocalRandom.current().nextInt(CONFIG.getSpeed(AnimalType.BEAR) - 1);
            int newY = bear.getPosition().getY() + ThreadLocalRandom.current().nextInt(CONFIG.getSpeed(AnimalType.BEAR) - 1);

            if (newX >= 0 && newX < CONFIG.getIslandWidth() && newY >= 0 && newY < CONFIG.getIslandHeight()) {
                bear.setPosition(new Position(newX, newY));
            }
        }
    }

    @Override
    public List<? extends Animal<?>> feed(List<? extends Animal<?>> animals) {
        int eatProbability = Integer.parseInt(CONFIG.getEatingProbability(Bear.class).stream()
                .filter(s -> animals.getClass().getSimpleName().equals(s))
                .findFirst()
                .get());
        return getAnimals(animals, eatProbability);
    }

    public List<Bear> breed(Visibility visibility) {
        if (this.gender != Gender.FEMALE) {
            return visibility.animals()
                    .map(animal -> animal instanceof Bear ? (Bear) animal : null)
                    .filter(Objects::nonNull)
                    .filter(otherBear -> ((AnimalInfo) otherBear).gender() != this.gender)
                    .findAny()
                    .stream()
                    .toList();
        }
        return null;

    }

    private Bear getBear(List<Bear> bears) {
        return bears.stream()
                .findFirst()
                .get();
    }

    public int getAllBears() {
        return bears.size();
    }

}
