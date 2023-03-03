package com.aleksei.animalisland.utils.info;

import com.aleksei.animalisland.utils.Pregnancy;
import com.aleksei.animalisland.utils.Gender;
import com.aleksei.animalisland.services.Position;
import com.aleksei.animalisland.repositories.gauge.AnimalGaugeInfo;

import java.util.Optional;

public interface AnimalInfo {
    AnimalGaugeInfo health();
    boolean adult();
    Optional<Pregnancy> pregnancy();
    Position getPosition();
    Gender gender();

}
