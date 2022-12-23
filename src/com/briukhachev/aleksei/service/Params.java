package com.briukhachev.aleksei.service;


import com.briukhachev.aleksei.animalfactory.AnimalType;
import com.briukhachev.aleksei.animalfactory.animals.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Params {
    private int plantWeight;
    private Map<Class, double[]> animalParams = new HashMap<>();
    private int[][] eatingProbability = new int[][]{
            {0, 0, 0, 0, 10, 15, 60, 80, 60, 70, 15, 10, 40, 0, 0},
            {0,	15, 0, 0, 0, 0, 20, 40, 0, 0, 0, 0, 10, 0, 0},
            {0, 0, 0, 0, 0, 0, 70, 90, 0, 0, 0, 0, 60, 40, 0},
            {0, 80, 0, 0, 40, 80, 80, 90, 70, 70, 50, 20, 10, 0, 0},
            {0, 0, 10, 0, 0, 0, 90, 90, 0, 0, 0, 0, 80, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0, 0, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100},
    };

    public void initAnimalParams() {
        animalParams.put(Wolf.class, new double[]{50, 30, 3, 8});
        animalParams.put(Snake.class, new double[]{15, 30, 1, 3});
        animalParams.put(Fox.class, new double[]{8, 30, 2, 2});
        animalParams.put(Bear.class, new double[]{500, 5, 2, 80});
        animalParams.put(Eagle.class, new double[]{6, 20, 3, 1});
        animalParams.put(Horse.class, new double[]{400, 20, 4, 60});
        animalParams.put(Deer.class, new double[]{300, 20, 4, 50});
        animalParams.put(Rabbit.class, new double[]{2, 150, 2, 0.45d});
        animalParams.put(Mouse.class, new double[]{0.05d, 500, 1, 0.01});
        animalParams.put(Goat.class, new double[]{60, 140, 3, 10});
        animalParams.put(Sheep.class, new double[]{70, 140, 3, 15});
        animalParams.put(Boar.class, new double[]{400, 50, 2, 50});
        animalParams.put(Buffalo.class, new double[]{700, 10, 3, 100});
        animalParams.put(Duck.class, new double[]{1, 200, 4, 0.15d});
        animalParams.put(Caterpillar.class, new double[]{0.01d, 1000, 0, 0});
    }
    public int getEatingProbability(AnimalType animalType, AnimalType typeToEat){
        if (animalType.ordinal() <= 15 && typeToEat.ordinal() <= 16 && animalType.ordinal() != typeToEat.ordinal()) {
            return eatingProbability[animalType.ordinal()][typeToEat.ordinal()];
        }
        return 0;
    }
    public double getAnimalWeight(Class clazz){
        return animalParams.get(clazz)[0];
    }
    public void setAnimalWeight(Class clazz, double weight){
        animalParams.get(clazz)[0] = weight;
    }
    public double getAnimalPerLocation(Class clazz){
        return animalParams.get(clazz)[1];
    }
    public void setAnimalPerLocation(Class clazz, int animalNumbers){
        animalParams.get(clazz)[1] = animalNumbers;
    }
    public double getAnimalSpeed(Class clazz){
        return animalParams.get(clazz)[2];
    }
    public void setAnimalSpeed(Class clazz, int speed){
        animalParams.get(clazz)[2] = speed;
    }
    public double getAnimalFoodQuantity(Class clazz){
        return animalParams.get(clazz)[3];
    }
    public void setAnimalFoodQuantity(Class clazz, double foodQuantity){
        animalParams.get(clazz)[3] = foodQuantity;
    }

    public int getPlantWeight() {
        return plantWeight;
    }

    public void setPlantWeight(int plantWeight) {
        this.plantWeight = plantWeight;
    }
}
