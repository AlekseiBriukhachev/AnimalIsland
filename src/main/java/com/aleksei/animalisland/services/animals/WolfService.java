package com.aleksei.animalisland.services.animals;


import com.aleksei.animalisland.config.BaseConfig;
import com.aleksei.animalisland.config.EntityConfig;
import com.aleksei.animalisland.models.Island.Location;
import com.aleksei.animalisland.models.animals.Animal;
import com.aleksei.animalisland.models.animals.EntityAI;
import com.aleksei.animalisland.models.animals.Wolf;
import com.aleksei.animalisland.repository.WolfInfo;
import com.aleksei.animalisland.repository.AnimalService;
import com.aleksei.animalisland.services.Food;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
public final class WolfService implements AnimalService<WolfInfo> {
    private final BaseConfig CONFIG = BaseConfig.getAppConfig();
    private final EntityConfig entityConfig = new EntityConfig();

    @Override
    public void feed(Location location) {

        for (Animal entity : location.getAnimals()) {
            Food food = entity instanceof Food ? (Food) entity : null;
            if (food != null) {
                location.getFoods().add(food);
            }
            sortByEatingProbability(location.getFoods(), entityConfig.getEatingProbability(Wolf.class));
        }


//        {
//
//            if (food != null) {
//                int eatProbability = entityConfig.getEatingProbability(Wolf.class).get(entity);
//
//                System.out.println(eatProbability);
//
//
//                if (ThreadLocalRandom.current().nextInt(eatProbability) < eatProbability) {
//                    eatEntity(food);
//                }
//            }
//        }
//        return Optional.empty();
    }

    private void sortByEatingProbability(List<Food> foods, Map<Class<? extends EntityAI>, Integer> eatingProbability) {
        List<Food> sortedList = new ArrayList<>();

//        for (int i = 0; i < foods.size() - 1; i++){
//            if (eatingProbability.get(foods.get(i).getClass()) < eatingProbability.get(foods.get(i + 1).getClass())){
//                int tempProb = eatingProbability.get(foods.get(i).getClass());
//                eatingProbability.get(foods.get(i).getClass()) = eatingProbability.get(foods.get(i + 1).getClass());
//
//            }
//        }
    }


}
