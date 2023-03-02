package src_temp.main.java.com.aleksei.island.entities;

import com.aleksei.island.enumartion.AnimalType;
import com.aleksei.island.service.Factories;

import java.awt.*;

public class Location {
    private int x;
    private int y;
    private boolean hasPlant;
    private boolean hasAnimal;
    public Location(){}

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isHasPlant() {
        return hasPlant;
    }

    public void setHasPlant(boolean hasPlant) {
        this.hasPlant = hasPlant;
    }

    public boolean isHasAnimal() {
        return hasAnimal;
    }

    public void setHasAnimal(boolean hasAnimal) {
        this.hasAnimal = hasAnimal;
    }

}
