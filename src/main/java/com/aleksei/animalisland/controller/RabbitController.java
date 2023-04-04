package com.aleksei.animalisland.controller;

import com.aleksei.animalisland.model.Location;
import com.aleksei.animalisland.model.Rabbit;
import com.aleksei.animalisland.service.RabbitService;
import com.aleksei.animalisland.service.RabbitServiceImpl;

public class RabbitController {
    private final RabbitService service = new RabbitServiceImpl();
    public void create(Location location, Rabbit rabbit){
        service.create(location, rabbit);
    }
}
