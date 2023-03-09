package com.aleksei.animalisland.repositories.info;



import com.aleksei.animalisland.services.Position;
import com.aleksei.animalisland.utils.Pregnancy;
import com.aleksei.animalisland.utils.Gender;
import com.aleksei.animalisland.utils.stats.NumberGaugeInfo;

import java.util.Optional;

public interface AnimalInfo {

    NumberGaugeInfo health();

    boolean adult();

    Optional<Pregnancy> pregnancy();

    Position getPosition();

    Gender gender();
}
