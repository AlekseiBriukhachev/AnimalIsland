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

@Slf4j
public final class RabbitService implements AnimalService<AnimalInfo>, RabbitInfo, Food {
    private final BaseConfig CONFIG = BaseConfig.getAppConfig();
    private final EntityConfig entityConfig = new EntityConfig();


    private boolean isHungry(AnimalInfo info) {
        return info.health().part() < 0.5d;

    }

    @Override
    public NumberGaugeInfo health() {
        return null;
    }

    @Override
    public void feed(Location location, AnimalInfo info) {
        int plantsAmountOnLocation = location.getPlants().size() * CONFIG.getPlantAmountWeight();
        if (plantsAmountOnLocation > 0) {

            for (Rabbit rabbit : location.getRabbits()) {
                double rabbitEat = 0;
                if (isHungry(info)) {
                    rabbitEat = plantsAmountOnLocation - CONFIG.getFoodQuantity(AnimalType.RABBIT);
                    log.info("Rabbit eat grass");
                }
                if (rabbitEat > plantsAmountOnLocation) {
                    break;
                }
            }
        }
    }
}
