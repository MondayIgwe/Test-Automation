package org.web.qa.test.cucumber;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    Map<String, Object> map;

    public ScenarioContext() {
        this.map = new HashMap<>(); // HAS-A represent composition relationship
    }

    public void setContext(String key, Object value) {
        map.put(key, value);
    }

    public Object getContext(String key) {
        return map.get(key);
    }

    public boolean isContext(String key) {
        return map.containsKey(key);
    }
}
