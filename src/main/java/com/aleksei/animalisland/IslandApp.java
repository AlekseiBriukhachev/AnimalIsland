package com.aleksei.animalisland;


import com.aleksei.animalisland.config.AppConfig;
import com.aleksei.animalisland.config.EntityConfig;
import com.aleksei.animalisland.models.animals.Bear;
import com.aleksei.animalisland.services.StartService;
import com.aleksei.animalisland.utils.enumartion.AnimalType;
import com.aleksei.animalisland.utils.factories.AnimalFactory;

import java.util.Arrays;

public class IslandApp {
    private static AnimalFactory animalFactory = AnimalFactory.getInstance();
    private static final AppConfig CONFIG = AppConfig.getAppConfig();
    private static final EntityConfig entity = new EntityConfig();
    public static void main(String[] args) {

        System.out.println(animalFactory.create(AnimalType.BEAR).getWeight());
        System.out.println(animalFactory.create(AnimalType.BEAR).getSpeed());
        System.out.println(animalFactory.create(AnimalType.BEAR).getFoodAmount());
        System.out.println(Arrays.toString(CONFIG.getEatingProbability(Bear.class)));

        System.out.println(entity.getEatingProbability(Bear.class).toString());

//        new Thread(new StartService()).start();
    }
}
