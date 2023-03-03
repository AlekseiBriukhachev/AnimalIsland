package com.aleksei.animalisland.services.animals;

import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.repositories.Food;
import com.aleksei.animalisland.repositories.Visibility;
import com.aleksei.animalisland.services.Position;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.IntStream;

@Slf4j
public class AnimalService {
    private Animal animal;
    private Position position;

//    public final void update(@NotNull Function<Animal, Visibility> updatedVisibility) {
//        log.debug("Updating status of animal");
//
//        updateAnimalState();
//
//        IntStream.range(0, animal.getSpeed())
//                .forEach(step -> {
//                    Visibility visibility = updatedVisibility.apply(animal);
//                    animal.move(visibility)
//                            .filter(position -> position.distance(animal.getPosition()) <= animal.getSpeed())
//                            .ifPresent(position -> {
//                                if (position.inPosition(visibility)) {
//                                    setPosition(position);
//                                    animal.leaveScent();
//                                }
//                            });
//                });
//        Visibility localVisibility = updatedVisibility.apply(animal).local(animal.getPosition());
//        Optional<Food> foodFound = animal.feed(localVisibility);
//        foodFound.ifPresent(food -> {
//            if (food.eaten()) {
//                log.debug("Animal {} [{}] on {} is eating", getClass().getSimpleName(), animal.getHealth(), animal.getPosition());
//                animal.getHealth().setCurrent(animal.getHealth().getCurrent() + food.getFoodValue());
//            }
//        });
//        if (animal.getHealth().part() > 0.5) {
//            animal.breed(localVisibility);
//        }
//    }
//    private void updateAnimalState() {
//
//        if (!animal.isAlive()) {
//            return;
//        }
//
//        log.debug("Animal is alive and grown up by 1 unit");
//
//        animal.getAge().plus(1);
//        animal.updateGauges();
//
//        if (isOldOrTooHungry()) {
//            log.debug("Animal is dead");
//            animalIsDie();
//        }
//    }
//    private boolean isOldOrTooHungry(){
//        return animal.getAge().atMax() || animal.getHealth().atMin();
//    }
//    public void animalIsDie(){
//        if (animal.isAlive()){
//            log.debug("Animal {} is die on {}", getClass().getSimpleName(), animal.getPosition());
//            animal.setAlive(false);
//            animal.getBirthListeners().clear();
//        }
//    }
}
