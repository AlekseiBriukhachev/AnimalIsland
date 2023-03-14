package com.aleksei.animalisland.models.Island;


import com.aleksei.animalisland.config.BaseProperties;

import java.util.Properties;

public class IslandConfig {
    private final BaseProperties reader = new BaseProperties("islandprops");
    private final Properties island;

    {
        island = reader.loadProperties("island");
    }

    public int getIslandSizeByX() {
        return Integer.parseInt(island.getProperty("x"));
    }

    public int getIslandSizeByY() {
        return Integer.parseInt(island.getProperty("y"));
    }
}
