package com.qa.main.helper;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Helper {
    /**
     * Java logics implementation
     */
    public static <T, V extends T> boolean isIn(T x, V[] y) {
        for (V v : y) {
            if (x.equals(v)) return true;
        }
        return false;
    }

    @SafeVarargs
    public final <T> List<T> getList(T... type) {
        return Arrays.asList(type);
    }

    public final void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }
}
