package ru.levelp.at.lesson13.bdd.context;

import java.util.HashMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TestContext {

    private static TestContext instance;

    private Map<String, Object> map = new HashMap<>();

    public void addObject(String key, Object value) {
        map.put(key, value);
    }

    public Object getObject(String key) {
        return map.get(key);
    }

    public void cleanUp() {
        map.clear();
        instance = null;
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }
}
