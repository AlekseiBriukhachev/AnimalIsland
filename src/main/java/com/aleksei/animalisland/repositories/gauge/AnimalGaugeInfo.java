package com.aleksei.animalisland.repositories.gauge;

public interface AnimalGaugeInfo {
    double part();
    Integer getCurrent();
    Integer getMin();
    Integer getMax();
    boolean atMax();
    boolean atMin();
}
