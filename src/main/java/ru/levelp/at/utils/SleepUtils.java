package ru.levelp.at.utils;

public final class SleepUtils {

    private SleepUtils() {
    }

    public static void sleep(long sleepTimeInMillis) {
        try {
            Thread.sleep(sleepTimeInMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
