package com.aleksei.animalisland.models.animals;

import com.aleksei.animalisland.models.Island.Island;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    @Test
    public void createBear(){
        Animal bear = new Bear();
        assertNotNull(bear);
    }
    @Test
    public void createIsland(){
        Island island = new Island();
        assertNotNull(island);
    }

}