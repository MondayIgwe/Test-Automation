package com.qa.main.helper;

public class Helper {

    public static <T, V extends T> boolean isIn(T x, V[] y) {
        for (V v : y) {
            if (x.equals(v)) return true;
        }
        return false;
    }
}
