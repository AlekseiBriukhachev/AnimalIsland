package com.aleksei.animalisland.controller;

import com.aleksei.animalisland.service.IslandService;
import com.aleksei.animalisland.service.IslandServiceImpl;

public class IslandController {
    private final IslandService service = new IslandServiceImpl();
    public void init() {
        service.init();

    }
}
