package com.aleksei.animalisland.view;

import com.aleksei.animalisland.controller.BearController;
import com.aleksei.animalisland.controller.GrassController;
import com.aleksei.animalisland.controller.IslandController;
import com.aleksei.animalisland.controller.RabbitController;

public class View {
    private final IslandController islandController = new IslandController();
    private final BearController bearController = new BearController();
    private final RabbitController rabbitController = new RabbitController();
    private final GrassController grassController = new GrassController();
    public void init(){
        islandController.init();

    }
}
