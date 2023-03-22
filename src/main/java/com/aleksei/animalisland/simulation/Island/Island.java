package com.aleksei.animalisland.simulation.Island;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor

public class Island {
    private final List<Location> island;

}
