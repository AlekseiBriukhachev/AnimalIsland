package com.briukhachev.aleksei.config;

import com.briukhachev.aleksei.animalfactory.AnimalType;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class Configuation {

    private int plantWeight;
    private int islandWidth;
    private int islandHeight;
    InputStream input = Configuation.class.getClassLoader().getResourceAsStream("config/config.properties");
    public int getEatingProbability(AnimalType animalType, AnimalType typeToEat) {
//        if (animalType.ordinal() < 0){
//            return 0;
//        }
//        if (typeToEat.ordinal() > 16)
        if (animalType.ordinal() != typeToEat.ordinal()) {
//            return eatingProbability[animalType.ordinal()][typeToEat.ordinal()];
        }
        return 0;
    }
    public void readProperties(){

        try {
            Properties properties = new Properties();
            if (input == null){
                System.out.println("Sorry, unable to find config file");
            }
            properties.load(input);
            properties.keySet().forEach(x -> System.out.println(x));
            Set<Object> objectSet = properties.keySet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public double getAnimalWeight(Class<? extends Animal> clazz) {
//        return animalParams.get(clazz)[0];
//    }
//
//    public void setAnimalWeight(Class<? extends Animal> key, double weight) {
//        animalParams.get(key)[0] = weight;
//    }
//
//    public double getAnimalPerLocation(Class<? extends Animal> clazz) {
//        return animalParams.get(clazz)[1];
//    }
//
//    public void setAnimalPerLocation(Class<? extends Animal> key, double animalNumbers) {
//        animalParams.get(key)[1] = animalNumbers;
//    }
//
//    public double getAnimalSpeed(Class<? extends Animal> clazz) {
//        return animalParams.get(clazz)[2];
//    }
//
//    public void setAnimalSpeed(Class<? extends Animal> clazz, double speed) {
//        animalParams.get(clazz)[2] = speed;
//    }
//
//    public double getAnimalFoodQuantity(Class<? extends Animal> clazz) {
//        return animalParams.get(clazz)[3];
//    }
//
//    public void setAnimalFoodQuantity(Class<? extends Animal> clazz, double foodQuantity) {
//        animalParams.get(clazz)[3] = foodQuantity;
//    }

    public int getPlantWeight() {
        return plantWeight;
    }

    public void setPlantWeight(int plantWeight) {
        this.plantWeight = plantWeight;
    }

    public int getIslandWidth() {
        return islandWidth;
    }

    public void setIslandWidth(int islandWidth) {
        this.islandWidth = islandWidth;
    }

    public int getIslandHeight() {
        return islandHeight;
    }

    public void setIslandHeight(int islandHeight) {
        this.islandHeight = islandHeight;
    }
}
