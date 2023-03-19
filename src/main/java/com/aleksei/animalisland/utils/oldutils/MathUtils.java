package com.aleksei.animalisland.utils;

public final class MathUtils {

    private MathUtils() {
    }

    public static int sgn(int a) {
        return a > 0 ? 1 : (a < 0 ? -1 : 0);
    }
}
