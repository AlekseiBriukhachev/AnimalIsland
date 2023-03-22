package com.aleksei.animalisland.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SimulationResult {
    private final long elapsedTime;
    private final int bearTotal;
    private final int boarTotal;
    private final int buffaloTotal;
    private final int caterpillarTotal;
    private final int deerTotal;
    private final int duckTotal;
    private final int eagleTotal;
    private final int foxTotal;
    private final int goatTotal;
    private final int horseTotal;
    private final int mouseTotal;
    private final int rabbitTotal;
    private final int sheepTotal;
    private final int snakeTotal;
    private final int wolvesTotal;

}
