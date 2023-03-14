package com.aleksei.animalisland.controller;

import com.aleksei.animalisland.models.animals.Bear;
import com.aleksei.animalisland.services.Position;
import com.aleksei.animalisland.services.Visibility;
import com.aleksei.animalisland.services.animals.BearService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class IslandController {
    private BearService bearService;

//    public Map<Position, Integer> evaluateBear(List<Bear> bears, Visibility visibility) {
//
//    }
}
