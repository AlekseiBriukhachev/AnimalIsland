package com.briukhachev.aleksei;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Params {
    private int wolfCount = 30;
    private int snakeCount = 30;
    private int foxCount = 30;
    private int bearCount = 5;
    private int eagleCount = 20;
    private int horseCount = 20;
    private int deerCount = 20;
    private int rabbitCount = 150;
    private int mouseCount = 500;
    private int goatCount = 140;
    private int sheepCount = 140;
    private int boarCount = 50;
    private int buffaloCount = 10;
    private int duckCount = 200;
    private int caterpillarCount = 1000;
    private int plantCount = 200;
    private int width = 100;
    private int height= 20;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private Map<Object, List<Integer>> organismParams = new HashMap<>();

    public Map<Object, List<Integer>> getOrganismParams() {
        return organismParams;
    }

    public int getPlantCount() {
        return plantCount;
    }

    public void setPlantCount(int plantCount) {
        this.plantCount = plantCount;
    }
    public int getDuckCount() {
        return duckCount;
    }

    public void setDuckCount(int duckCount) {
        this.duckCount = duckCount;
    }

    public int getWolfCount() {
        return wolfCount;
    }

    public void setWolfCount(int wolfCount) {
        this.wolfCount = wolfCount;
    }

    public int getSnakeCount() {
        return snakeCount;
    }

    public void setSnakeCount(int snakeCount) {
        this.snakeCount = snakeCount;
    }

    public int getFoxCount() {
        return foxCount;
    }

    public void setFoxCount(int foxCount) {
        this.foxCount = foxCount;
    }

    public int getBearCount() {
        return bearCount;
    }

    public void setBearCount(int bearCount) {
        this.bearCount = bearCount;
    }

    public int getEagleCount() {
        return eagleCount;
    }

    public void setEagleCount(int eagleCount) {
        this.eagleCount = eagleCount;
    }

    public int getHorseCount() {
        return horseCount;
    }

    public void setHorseCount(int horseCount) {
        this.horseCount = horseCount;
    }

    public int getDeerCount() {
        return deerCount;
    }

    public void setDeerCount(int deerCount) {
        this.deerCount = deerCount;
    }

    public int getRabbitCount() {
        return rabbitCount;
    }

    public void setRabbitCount(int rabbitCount) {
        this.rabbitCount = rabbitCount;
    }

    public int getMouseCount() {
        return mouseCount;
    }

    public void setMouseCount(int mouseCount) {
        this.mouseCount = mouseCount;
    }

    public int getGoatCount() {
        return goatCount;
    }

    public void setGoatCount(int goatCount) {
        this.goatCount = goatCount;
    }

    public int getSheepCount() {
        return sheepCount;
    }

    public void setSheepCount(int sheepCount) {
        this.sheepCount = sheepCount;
    }

    public int getBoarCount() {
        return boarCount;
    }

    public void setBoarCount(int boarCount) {
        this.boarCount = boarCount;
    }

    public int getBuffaloCount() {
        return buffaloCount;
    }

    public void setBuffaloCount(int buffaloCount) {
        this.buffaloCount = buffaloCount;
    }

    public int getCaterpillarCount() {
        return caterpillarCount;
    }

    public void setCaterpillarCount(int caterpillarCount) {
        this.caterpillarCount = caterpillarCount;
    }
}
