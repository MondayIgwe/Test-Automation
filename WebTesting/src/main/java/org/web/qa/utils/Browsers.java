package org.web.qa.utils;

public enum Browsers {
    CHROME("chrome"), CHROMIUM("chromium"), FIREFOX("mozilla"),
    EDGE("edge"), SAFARI("safari");

    final String engine;
    Browsers(String engine) {
        this.engine = engine;
    }
}
