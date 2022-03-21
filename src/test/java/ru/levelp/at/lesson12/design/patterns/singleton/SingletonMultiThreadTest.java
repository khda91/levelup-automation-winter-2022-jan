package ru.levelp.at.lesson12.design.patterns.singleton;

import org.testng.annotations.Test;

public class SingletonMultiThreadTest {

    @Test(threadPoolSize = 4, invocationCount = 4)
    public void singleThreadSingleton() {
        System.out.println(String.format("-----\n"
                + "method name -> singleThreadSingleton\n"
                + "thead id -> %d\n"
                + "thread name -> %s\n"
                + "singleton value -> %s\n"
                + "-----\n", Thread.currentThread().getId(), Thread.currentThread().getName(),
            SingletonExample.getInstance().getValue()));
    }

    @Test(threadPoolSize = 4, invocationCount = 4)
    public void multiThreadSingleton() {
        System.out.println(String.format("-----\n"
                + "method name -> multiThreadSingleton\n"
                + "thead id -> %d\n"
                + "thread name -> %s\n"
                + "singleton value -> %s\n"
                + "-----\n", Thread.currentThread().getId(), Thread.currentThread().getName(),
            MultiThreadSingletonExample.getInstance().getValue()));
    }

}
