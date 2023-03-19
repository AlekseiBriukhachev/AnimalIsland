package com.aleksei.animalisland.utils;

import lombok.Data;

@Data
public class UpdateResult {

    private final long elapsed;
    private final int boarsTotal;
    private final int bearsTotal;

    public UpdateResult(long elapsed, int boarsTotal, int bearsTotal) {
        this.elapsed = elapsed;
        this.boarsTotal = boarsTotal;
        this.bearsTotal = bearsTotal;
    }
}
