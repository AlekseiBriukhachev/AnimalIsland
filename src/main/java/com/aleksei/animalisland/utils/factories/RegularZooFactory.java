package com.aleksei.animalisland.utils.factories;


import com.aleksei.animalisland.models.animals.Bear;
import com.aleksei.animalisland.models.animals.Boar;
import com.aleksei.animalisland.services.Position;
import com.aleksei.animalisland.utils.enumartion.AnimalType;

public class RegularZooFactory implements ZooFactory {
    private final AnimalFactory animalFactory = AnimalFactory.getInstance();

    @Override
    public Boar createBoar(Position position) {
        return (Boar) animalFactory.create(AnimalType.BOAR);
    }

    @Override
    public Bear createBear(Position position) {
        return (Bear) animalFactory.create(AnimalType.BEAR);
    }
}
