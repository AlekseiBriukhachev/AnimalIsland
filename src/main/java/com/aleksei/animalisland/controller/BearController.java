package com.aleksei.animalisland.controller;

import com.aleksei.animalisland.model.Bear;
import com.aleksei.animalisland.model.Location;
import com.aleksei.animalisland.service.BearService;
import com.aleksei.animalisland.service.BearServiceImpl;

public class BearController {
    private final BearService service = new BearServiceImpl();
    public void create(Location location, Bear bear){
        service.create(location, bear);
    }
}
