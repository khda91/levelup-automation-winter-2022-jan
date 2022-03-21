package ru.levelp.at.lesson12.design.patterns.builder;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PersonBuilderTest {

    @DataProvider
    public Object[][] parametersForPersonDataProvider() {
        final var faker = new Faker();
        return new Object[][] {
            {faker.name().firstName(), faker.name().lastName(), faker.name().nameWithMiddle(),
                Integer.parseInt(RandomStringUtils.randomNumeric(1, 3)), faker.internet().emailAddress()},
            {faker.name().firstName(), faker.name().lastName(), faker.name().nameWithMiddle(),
                Integer.parseInt(RandomStringUtils.randomNumeric(1, 3)), faker.internet().emailAddress()},
            {faker.name().firstName(), faker.name().lastName(), null,
                Integer.parseInt(RandomStringUtils.randomNumeric(1, 3)), faker.internet().emailAddress()},
            {null, null, faker.name().nameWithMiddle(),
                Integer.parseInt(RandomStringUtils.randomNumeric(1, 3)), faker.internet().emailAddress()},
            {null, null, null, null, null}
        };
    }

    @Test(dataProvider = "parametersForPersonDataProvider")
    public void personBuilderTest(String firstName, String lastName, String middleName, Integer age, String email) {
        var person = Person.builder()
                           .firstName(firstName)
                           .lastName(lastName)
                           .middleName(middleName)
                           .age(age)
                           .email(email)
                           .build();
        System.out.println(person);
        System.out.println();
    }

    @DataProvider
    public Object[][] valueObjectForPersonDataProvider() {
        final var faker = new Faker();
        return new Object[][] {
            {Person.builder()
                   .firstName(faker.name().firstName())
                   .lastName(faker.name().lastName())
                   .middleName(faker.name().nameWithMiddle())
                   .age(Integer.parseInt(RandomStringUtils.randomNumeric(1, 3)))
                   .email(faker.internet().emailAddress())
                .build()
            },
            {Person.builder()
                   .firstName(faker.name().firstName())
                   .lastName(faker.name().lastName())
                   .age(Integer.parseInt(RandomStringUtils.randomNumeric(1, 3)))
                   .email(faker.internet().emailAddress())
                .build()
            },
            {Person.builder()
                   .middleName(faker.name().nameWithMiddle())
                   .age(Integer.parseInt(RandomStringUtils.randomNumeric(1, 3)))
                   .email(faker.internet().emailAddress())
                .build()
            },
            {Person.builder()
                .build()
            }
        };
    }

    @Test(dataProvider = "valueObjectForPersonDataProvider")
    public void valueObjectPersonBuilderTest(Person person) {
        System.out.println(person);
        System.out.println();
    }
}
