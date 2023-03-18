package com.aleksei.animalisland.services.animals;


import com.aleksei.animalisland.config.BaseConfig;
import com.aleksei.animalisland.models.Island.Location;
import com.aleksei.animalisland.models.animals.Animal;
import com.aleksei.animalisland.models.animals.Bear;
import com.aleksei.animalisland.repository.BearInfo;
import com.aleksei.animalisland.repository.AnimalService;
import com.aleksei.animalisland.services.Food;
import com.aleksei.animalisland.utils.enumartion.AnimalType;
import com.aleksei.animalisland.utils.factories.AnimalFactory;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
public final class BearService implements AnimalService<BearInfo> {
    private final BaseConfig CONFIG = BaseConfig.getAppConfig();
    @Getter
    @Setter
    private List<Bear> bears;

    {
        bears = IntStream.range(0, CONFIG.getInitNumber(Bear.class))
                .mapToObj(i -> (Bear) AnimalFactory.getInstance().create(AnimalType.BEAR))
                .toList();
    }
    @Override
    public void feed(Location location, BearInfo info) {
        for (Animal entity : location.getAnimals()) {
            Food food = entity instanceof Food ? (Food) entity : null;
            int[] eatProbability = CONFIG.getEatingProbability(Bear.class);

            if (food != null) {
                if (eatEntity(food)) {
//                    return Optional.of(food);
                }
            }
        }
    }


    private boolean eatEntity(Food entity) {
        int eatProbability = Integer.parseInt(Arrays.toString(CONFIG.getEatingProbability(Bear.class)));
//        Food food = entity.getClass();
        System.out.println(eatProbability);
        return false;


//                .filter(s -> entity.getClass().getSimpleName().equals(s))
//                .findFirst()
//                .get());
//        return getAnimals(animals, eatProbability);
    }
}
