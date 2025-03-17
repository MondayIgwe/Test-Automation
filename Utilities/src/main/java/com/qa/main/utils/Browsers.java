package com.qa.main.utils;

public enum Browsers {
    CHROME("chrome"), CHROMIUM("chromium"), FIREFOX("mozilla"),
    EDGE("edge"), SAFARI("safari");

    private final String engine;

    Browsers(String engine) {
        this.engine = engine;
    }

    public String getBrowserId() {
        return engine;
    }
}

