package com.aleksei.animalisland.models;

import com.aleksei.animalisland.repositories.Food;
import com.aleksei.animalisland.repositories.ScentStorage;
import com.aleksei.animalisland.repositories.Visibility;
import com.aleksei.animalisland.repositories.gauge.AnimalGauge;
import com.aleksei.animalisland.services.Position;
import com.aleksei.animalisland.utils.info.AnimalInfo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;

@Data
@Slf4j
public abstract class Animal<T extends Animal<T>> implements AnimalInfo {
    private boolean isAlive = true;
    private final double weight;
    private final int speed;
    private final int sight;
    private double foodQuantity;
    private Position position;
    protected final AnimalGauge age;
    protected final AnimalGauge health = new AnimalGauge(0, 100);
    private final List<Consumer<T>> birthListeners = new LinkedList<>();
    private final ScentStorage scentStorage;
    private final List<Class<? extends Food>> food;

    public Animal(double weight, int speed, int sight, AnimalGauge age, ScentStorage scentStorage, List<Class<? extends Food>> food) {
        this.weight = weight;
        this.speed = speed;
        this.sight = sight;
        this.age = age;
        this.scentStorage = scentStorage;
        this.food = food;
    }
    public final void update(@NotNull Function<Animal, Visibility> updatedVisibility) {
        log.debug("Updating status of animal");

        updateAnimalState();

        IntStream.range(0, speed)
                .forEach(step -> {
                    Visibility visibility = updatedVisibility.apply(this);
                    move(visibility)
                            .filter(position -> position.getDistance(getPosition()) <= speed)
                            .ifPresent(position -> {
                                if (position.inPosition(visibility)) {
                                    setPosition(position);
                                    leaveScent();
                                }
                            });
                });
        Visibility localVisibility = updatedVisibility.apply(this).local(getPosition());
        Optional<Food> foodFound = feed(localVisibility);
        foodFound.ifPresent(food -> {
            if (food.eaten()) {
                log.debug("Animal {} [{}] on {} is eating", getClass().getSimpleName(), getHealth(), getPosition());
                getHealth().setCurrent(getHealth().getCurrent() + food.getFoodValue());
            }
        });
        if (getHealth().part() > 0.5) {
            breed(localVisibility);
        }
    }
    private void updateAnimalState() {

        if (!isAlive()) {
            return;
        }

        log.debug("Animal is alive and grown up by 1 unit");

        getAge().plus(1);
        updateGauges();

        if (isOldOrTooHungry()) {
            log.debug("Animal is dead");
            animalIsDie();
        }
    }
    private boolean isOldOrTooHungry(){
        return getAge().atMax() || getHealth().atMin();
    }
    public void animalIsDie(){
        if (isAlive()){
            log.debug("Animal {} is die on {}", getClass().getSimpleName(), getPosition());
            setAlive(false);
            getBirthListeners().clear();
        }
    }

    public final boolean canEat(Class<? extends Food> foodClass){
        return food.stream()
                .anyMatch(eatable -> eatable.isAssignableFrom(foodClass));
        //FIXME insert here eating probability            .filter(eatable -> eatable.)
    }

    public abstract Optional<Food> feed(Visibility localVisibility);

    public abstract Optional<Position> move(Visibility visibility);

    public abstract void breed(Visibility visibility);

    public abstract Map<Position, Integer> evaluate(Visibility visibility);
    public abstract void updateGauges();

    public void birth(T animal) {
        birthListeners.forEach(birthAnimal -> birthAnimal.accept(animal));
    }
    public void addBirthListener(Consumer<T> listener){
        birthListeners.add(listener);
    }
    public void leaveScent() {
        scentStorage.update(getPosition());
    }
}
