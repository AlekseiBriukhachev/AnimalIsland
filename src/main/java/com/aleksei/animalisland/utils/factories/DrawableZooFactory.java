package com.aleksei.animalisland.utils.factories;
import com.aleksei.animalisland.models.animals.Bear;
import com.aleksei.animalisland.models.animals.Boar;
import com.aleksei.animalisland.services.Position;
import com.aleksei.animalisland.view.DrawableBear;
import com.aleksei.animalisland.view.DrawableBoar;

public interface DrawableZooFactory {

    DrawableBoar createBoar(Position position);

    DrawableBear createBear(Position position);

    DrawableBoar wrap(Boar boar);

    DrawableBear wrap(Bear bear);
}
