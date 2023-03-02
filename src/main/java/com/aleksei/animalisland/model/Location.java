package com.aleksei.animalisland.model;

import com.briukhachev.aleksei.animalfactory.OrganismType;

import java.awt.*;

public class Location {
    private int x;
    private int y;

    private OrganismType image;

    public Location() {
        image = OrganismType.EMPTY;
    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setImage(OrganismType image) {
        this.image = image;
    }

    public OrganismType getImage() {
        return image;
    }

    public Image chooseImage(OrganismType animalType) {
        return switch (animalType) {
            case BEAR -> Toolkit.getDefaultToolkit().getImage("res/Bear.png");
            case BOAR -> Toolkit.getDefaultToolkit().getImage("res/Boar.png");
            case BUFFALO -> Toolkit.getDefaultToolkit().getImage("res/Buffalo.png");
            case CATERPILLAR -> Toolkit.getDefaultToolkit().getImage("res/Caterpillar.png");
            case DEER -> Toolkit.getDefaultToolkit().getImage("res/Deer.png");
            case DUCK -> Toolkit.getDefaultToolkit().getImage("res/Duck.png");
            case EAGLE -> Toolkit.getDefaultToolkit().getImage("res/Eagle.png");
            case FOX -> Toolkit.getDefaultToolkit().getImage("res/Fox.png");
            case GOAT -> Toolkit.getDefaultToolkit().getImage("res/Goat.png");
            case HORSE -> Toolkit.getDefaultToolkit().getImage("res/Horse.png");
            case MOUSE -> Toolkit.getDefaultToolkit().getImage("res/Mouse.png");
            case RABBIT -> Toolkit.getDefaultToolkit().getImage("res/Rabbit.png");
            case SHEEP -> Toolkit.getDefaultToolkit().getImage("res/Sheep.png");
            case SNAKE -> Toolkit.getDefaultToolkit().getImage("res/Snake.png");
            case WOLF -> Toolkit.getDefaultToolkit().getImage("res/Wolf.png");
            case PLANT -> Toolkit.getDefaultToolkit().getImage("res/Plant.png");
            default -> Toolkit.getDefaultToolkit().getImage("res/Empty.png");
        };
    }
}
