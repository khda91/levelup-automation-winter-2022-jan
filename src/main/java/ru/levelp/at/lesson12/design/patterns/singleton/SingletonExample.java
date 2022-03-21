package ru.levelp.at.lesson12.design.patterns.singleton;

import org.apache.commons.lang3.RandomStringUtils;

public class SingletonExample {

    private static SingletonExample instance;

    private final String value;

    private SingletonExample() {
        this.value = RandomStringUtils.randomAlphanumeric(9);
    }

    public String getValue() {
        return value;
    }

    public static SingletonExample getInstance() {
        if (instance == null) {
            instance = new SingletonExample();
        }

        return instance;
    }
}
