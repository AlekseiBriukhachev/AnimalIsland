package com.aleksei.animalisland.simulation;

import com.aleksei.animalisland.dao.SimulationResult;
import com.aleksei.animalisland.simulation.Island.Island;

public interface Simulation {
    SimulationResult startSimulation(Island island);
}
