package com.aleksei.animalisland.utils.factory;
import com.aleksei.animalisland.services.Position;
public interface DrawableZooFactory {

    DrawableRabbit createRabbit(Position position, RabbitExample example, ScentStorage scentStorage);

    DrawableWolf createWolf(Position position, WolfExample example, ScentStorage scentStorage);

    DrawableRabbit wrap(Rabbit rabbit);

    DrawableWolf wrap(Wolf wolf);
}
