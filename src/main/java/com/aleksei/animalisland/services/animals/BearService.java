package com.aleksei.animalisland.services.animals;

import com.aleksei.animalisland.config.AppConfig;
import com.aleksei.animalisland.models.AI;
import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.models.AnimalEntity;
import com.aleksei.animalisland.models.animals.Bear;
import com.aleksei.animalisland.repositories.Food;
import com.aleksei.animalisland.repositories.info.AnimalInfo;
import com.aleksei.animalisland.services.Position;
import com.aleksei.animalisland.services.Visibility;
import com.aleksei.animalisland.utils.Gender;
import com.aleksei.animalisland.utils.Pregnancy;
import com.aleksei.animalisland.utils.enumartion.AnimalType;
import com.aleksei.animalisland.utils.factories.AnimalFactory;
import com.aleksei.animalisland.utils.stats.NumberGaugeInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static com.aleksei.animalisland.utils.Utils.getAnimals;

@Slf4j
public final class BearService<T extends Animal<T>> implements AnimalEntity, AnimalInfo {
    private final AppConfig CONFIG = AppConfig.getAppConfig();
    protected Gender gender;
    private Optional<Pregnancy> pregnancy = Optional.empty();
    public static final int PREGNANCY_TIME = 0;//TODO = CONFIG.getInt("pregnancyTime");
    private AI<Bear> ai;
    private final List<Bear> bears;

    {
        bears = IntStream.range(0, CONFIG.getInitNumber(Bear.class))
                .mapToObj(i -> (Bear) AnimalFactory.getInstance().create(AnimalType.BEAR))
                .toList();
    }

    @Override
    public Optional<Pregnancy> pregnancy() {
        return pregnancy;
    }

    @Override
    public Gender gender() {
        return gender;
    }

    @Override
    public NumberGaugeInfo health() {
        return null;
    }

    @Override
    public boolean adult() {
        return false;
    }

    @Override
    public Position getPosition() {
        return null;
    }

    @Override
    public Map<Position, Integer> evaluate(Visibility visibility) {
        return ai.evaluate(getBear(bears), visibility);
    }

    @Override
    public Optional<Position> move(Visibility visibility) {
        return ai.move(getBear(bears), visibility);
    }
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
    public Optional<Food> feed(Visibility visibility) {
        return ai.feed(getBear(bears), visibility);
    }
    public List<? extends Animal<?>> eat(List<? extends Animal<?>> animals) {
        int eatProbability = Integer.parseInt(CONFIG.getEatingProbability(Bear.class).stream()
                .filter(s -> animals.getClass().getSimpleName().equals(s))
                .findFirst()
                .get());
        return getAnimals(animals, eatProbability);
    }

    @Override
    public void breed(Visibility visibility) {
        if (this.gender != Gender.FEMALE || !adult() || pregnancy().isPresent()) {
            return;
        }
        visibility.animals()
                .map(animal -> animal instanceof Bear ? (Bear) animal : null)
                .filter(Objects::nonNull)
                .filter(otherBear -> ((AnimalInfo) otherBear).gender() != this.gender && ((AnimalInfo) otherBear).adult())
                .findAny()
                .ifPresent(mate -> pregnancy = Optional.of(new Pregnancy(PREGNANCY_TIME)));
    }

    public List<Bear> breed() {

        bears.add((Bear) AnimalFactory.getInstance().create(AnimalType.BEAR));
        return bears;

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
