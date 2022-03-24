package ru.levelp.at.lesson13.bdd.steps;

import io.cucumber.java.en.Then;

public class ComparisonSteps {

    @Then("expression should be next {int} {string} {int}")
    public void compariosnStep(Integer a, String sign, Integer b) {
        if ("<".equals(sign)) {
            assert a < b;
        }
    }
}
