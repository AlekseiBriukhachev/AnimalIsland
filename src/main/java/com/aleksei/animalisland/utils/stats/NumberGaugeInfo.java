package com.aleksei.animalisland.utils.stats;

public interface NumberGaugeInfo {

    float part();

    Integer getCurrent();

    Integer getMin();

    Integer getMax();

    boolean atMax();

    boolean atMin();
}
