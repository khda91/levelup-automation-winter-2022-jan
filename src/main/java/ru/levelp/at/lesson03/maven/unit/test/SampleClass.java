package ru.levelp.at.lesson03.maven.unit.test;

// import org.testng.annotations.Test;
// не работает так как у TestNg scope = test
public class SampleClass {

    // @Test
    public void test() {

    }

    public static void gradleTest() {
        System.out.println("Executed from gradle build");
    }
}
