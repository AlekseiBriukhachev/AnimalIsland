package com.aleksei.animalisland.utils.stats;

public class NumberGauge extends Gauge<Integer> implements NumberGaugeInfo {

    public NumberGauge(Integer current, Integer min, Integer max) {
        super(current, min, max);
    }

    public NumberGauge(Integer min, Integer max) {
        super(max, min, max);
    }

    @Override
    public float part() {
        return getCurrent().floatValue() / getMax().floatValue();
    }

    public void plus(int delta) {
        setCurrent(getCurrent() + delta);
    }

    public void minus(int delta) {
        setCurrent(getCurrent() - delta);
    }

    @Override
    public String toString() {
        return String.format("%d/%d", getCurrent(), getMax());
    }
}
