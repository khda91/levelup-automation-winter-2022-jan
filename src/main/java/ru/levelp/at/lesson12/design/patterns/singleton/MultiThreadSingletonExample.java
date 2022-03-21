package ru.levelp.at.lesson12.design.patterns.singleton;

import org.apache.commons.lang3.RandomStringUtils;

public class MultiThreadSingletonExample {

    private static volatile MultiThreadSingletonExample instance;

    private final String value;

    private MultiThreadSingletonExample() {
        this.value = RandomStringUtils.randomAlphanumeric(9);
    }

    public String getValue() {
        return value;
    }

    public static MultiThreadSingletonExample getInstance() {
        MultiThreadSingletonExample result = instance;
        if (result == null) {
            synchronized (MultiThreadSingletonExample.class) {
                result = instance;
                if (result == null) {
                    instance = new MultiThreadSingletonExample();
                }
            }
        }

        return instance;
    }
}
