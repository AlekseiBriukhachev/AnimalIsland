package com.aleksei.animalisland.services.animals;


import com.aleksei.animalisland.config.BaseConfig;
import com.aleksei.animalisland.config.EntityConfig;
import com.aleksei.animalisland.models.Island.Location;
import com.aleksei.animalisland.models.animals.Rabbit;
import com.aleksei.animalisland.repository.AnimalService;
import com.aleksei.animalisland.services.Food;
import com.aleksei.animalisland.utils.enumartion.AnimalType;
import com.aleksei.animalisland.repository.AnimalInfo;
import com.aleksei.animalisland.repository.RabbitInfo;
import com.aleksei.animalisland.utils.stats.NumberGaugeInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public final class RabbitService implements AnimalService<AnimalInfo>, Food {
    private final BaseConfig CONFIG = BaseConfig.getAppConfig();
    private final EntityConfig entityConfig = new EntityConfig();


    @Override
    public void feed(Location location) {
        updateGauges(location);
        double plantsAmountOnLocation = location.getPlants().size() * CONFIG.getPlantAmountWeight();
        double rabbitEat = 0;

        if (plantsAmountOnLocation > 0) {
            for (Rabbit rabbit : location.getRabbits()) {

                if (rabbit.isHungry()) {
                    plantsAmountOnLocation -= CONFIG.getFoodQuantity(AnimalType.RABBIT);
                    rabbitEat += CONFIG.getFoodQuantity(AnimalType.RABBIT);
                    log.info("Rabbit eat grass");
                }
                if (rabbitEat > plantsAmountOnLocation) {
                    break;
                }
            }
            for (int i = 0; i < rabbitEat; i++) {
                location.getPlants().remove(i);
            }
        }
    }

    private void updateGauges(Location location) {
        for (Rabbit rabbit : location.getRabbits()) {
            rabbit.getHealth().minus(10);
        }

    }

}
