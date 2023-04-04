package com.aleksei.animalisland.controller;

import com.aleksei.animalisland.model.Grass;
import com.aleksei.animalisland.model.Location;
import com.aleksei.animalisland.service.GrassService;
import com.aleksei.animalisland.service.GrassServiceImpl;

public class GrassController {
    private final GrassService service = new GrassServiceImpl();
    public void create(Location location, Grass grass){
        service.create(location, grass);
    }
}
