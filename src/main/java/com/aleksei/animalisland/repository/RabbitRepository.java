package com.aleksei.animalisland.repository;

import com.aleksei.animalisland.model.BaseEntity;
import com.aleksei.animalisland.model.Rabbit;

public interface RabbitRepository<T extends Rabbit> extends Herbivores<T> {
}
