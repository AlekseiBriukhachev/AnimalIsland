package com.aleksei.animalisland.services;


import com.aleksei.animalisland.config.EntityConfig;
import com.aleksei.animalisland.models.Island.Location;
import com.aleksei.animalisland.models.animals.*;
import com.aleksei.animalisland.repository.*;
import com.aleksei.animalisland.repository.inmemory.*;
import com.aleksei.animalisland.utils.EatingUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class AnimalService {
    private final EatingUtil eatingUtil = new EatingUtil(this);
    private Location location;
    private final EntityConfig entityConfig = EntityConfig.getInstance();
    private BearRepository bearRepository;
    private BoarRepository boarRepository;
    private BuffaloRepository buffaloRepository;
    private CaterpillarRepository caterpillarRepository;
    private DeerRepository deerRepository;
    private DuckRepository duckRepository;
    private EagleRepository eagleRepository;
    private FoxRepository foxRepository;
    private GoatRepository goatRepository;
    private HorseRepository horseRepository;
    private MouseRepository mouseRepository;
    private RabbitRepository rabbitRepository;
    private SheepRepository sheepRepository;
    private SnakeRepository snakeRepository;
    private WolfRepository wolfRepository;

    public void init() {
        bearRepository = new InMemoryBearRepository();
        boarRepository = new InMemoryBoarRepository();
        buffaloRepository = new InMemoryBuffaloRepository();
        caterpillarRepository = new InMemoryCaterpillarRepository();
        deerRepository = new InMemoryDeerRepository();
        duckRepository = new InMemoryDuckRepository();
        eagleRepository = new InMemoryEagleRepository();
        foxRepository = new InMemoryFoxRepository();
        goatRepository = new InMemoryGoatRepository();
        horseRepository = new InMemoryHorseRepository();
        mouseRepository = new InMemoryMouseRepository();
        rabbitRepository = new InMemoryRabbitRepository();
        sheepRepository = new InMemorySheepRepository();
        snakeRepository = new InMemorySnakeRepository();
        wolfRepository = new InMemoryWolfRepository();
    }

    public void animalEat(Location location) {
        this.location = location;
        for (int i = 0; i < location.getAnimals().size(); i++) {
            Animal animal = location.getAnimals().get(i);
            validateAndEatAnimal(animal);
//            animalHunt(location.getAnimals().get(i));
        }
    }

    private void validateAndEatAnimal(Animal animal) {
        if (animal instanceof Bear) {
            bearRepository.eatOtherAnimal(eatingUtil.getAnimalToEat());
        } else if (animal instanceof Boar) {
            boarRepository.eatGrass();
        } else if (animal instanceof Buffalo) {
            buffaloRepository.eatGrass();
        }else if (animal instanceof Caterpillar){
            caterpillarRepository.eatGrass();
        } else if (animal instanceof Deer) {
            deerRepository.eatGrass();
        } else if (animal instanceof Duck) {
            duckRepository.eatGrass();
        } else if (animal instanceof Eagle) {
            eagleRepository.eatOtherAnimal(eatingUtil.getAnimalToEat());
        } else if (animal instanceof Fox) {
            foxRepository.eatOtherAnimal(eatingUtil.getAnimalToEat());
        } else if (animal instanceof Goat) {
            goatRepository.eatGrass();
        } else if (animal instanceof Horse) {
            horseRepository.eatGrass();
        } else if (animal instanceof Mouse) {
            mouseRepository.eatGrass();
        } else if (animal instanceof Rabbit) {
            rabbitRepository.eatGrass();
        } else if (animal instanceof Sheep) {
            sheepRepository.eatGrass();
        } else if (animal instanceof Snake) {
            snakeRepository.eatOtherAnimal(eatingUtil.getAnimalToEat());
        } else if (animal instanceof Wolf) {
            wolfRepository.eatOtherAnimal(eatingUtil.getAnimalToEat());
        }
    }
}