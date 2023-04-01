package com.aleksei.animalisland.models.Island;

import com.aleksei.animalisland.config.IslandConfig;
import com.aleksei.animalisland.models.animals.EntityAI;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Island {
    private final IslandConfig islandConfig = new IslandConfig();
    private final int x = islandConfig.getIslandSizeByX();
    private final int y = islandConfig.getIslandSizeByY();

}
