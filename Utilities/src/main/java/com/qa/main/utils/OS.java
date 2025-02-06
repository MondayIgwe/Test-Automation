package com.qa.main.utils;

public enum OS {
    WINDOWS("Windows"),
    MAC("Mac"),
    LINUX("Linux");

    private final String os;

    OS(String os) {
        this.os = os;
    }

    public String getOs() {
        return os;
    }
}
