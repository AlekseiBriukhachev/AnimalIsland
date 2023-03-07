package com.aleksei.animalisland.utils.factories;


import com.aleksei.animalisland.models.animals.Bear;
import com.aleksei.animalisland.models.animals.Boar;
import com.aleksei.animalisland.services.Position;

public interface ZooFactory {

    Boar createBoar(Position position);

    Bear createBear(Position position);
}
