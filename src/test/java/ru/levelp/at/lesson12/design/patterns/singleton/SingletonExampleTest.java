package ru.levelp.at.lesson12.design.patterns.singleton;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SingletonExampleTest {

    @BeforeMethod
    public void setUp() {
        System.out.println("set up method");
        System.out.println("singleton value -> " + SingletonExample.getInstance().getValue());
        System.out.println();
    }

    @Test
    public void test1() {
        System.out.println("test1 method");
        System.out.println("singleton value -> " + SingletonExample.getInstance().getValue());
        System.out.println();
    }

    @Test
    public void test2() {
        System.out.println("test2 method");
        System.out.println("singleton value -> " + SingletonExample.getInstance().getValue());
        System.out.println();
    }

    @Test
    public void test3() {
        System.out.println("test3 method");
        System.out.println("singleton value -> " + SingletonExample.getInstance().getValue());
        System.out.println();
    }
}
