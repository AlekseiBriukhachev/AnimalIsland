package com.aleksei.animalisland.utils.factories;


import com.aleksei.animalisland.models.Island.Island;
import com.aleksei.animalisland.utils.factories.CellFactory;

public class IslandFactory {
    private final Island island = new Island();
    private final CellFactory cellFactory = new CellFactory();

    public  Island getInitialIsland() {
        for (int i = 0; i < island.getX(); i++) {
            for (int j = 0; j < island.getY(); j++) {
                island.getIsland().get(i).add(j, cellFactory.createCell());
            }
        }
        return island;
    }
}
