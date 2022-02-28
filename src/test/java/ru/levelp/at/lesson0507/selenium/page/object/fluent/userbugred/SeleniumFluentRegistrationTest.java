package ru.levelp.at.lesson0507.selenium.page.object.fluent.userbugred;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0507.selenium.page.object.SeleniumPageObjectBaseTest;

public class SeleniumFluentRegistrationTest extends SeleniumPageObjectBaseTest {

    private static final Faker FAKER = new Faker();

    @Test
    public void registrationTest() {
        final var username = FAKER.name().username();

        var actualUsername = new UserBugRedLoginRegistrationPage(driver)
            .open()
            .sendKeysToNameTextField(username)
            .sendKeysToEmailTextField(FAKER.internet().emailAddress())
            .sendKeysToPasswordTextField(FAKER.internet().password())
            .clickToRegisterButton()
            .getUsername();

        assertThat(actualUsername)
            .as("Incorrect username was displayed")
            .isEqualTo(username);
    }

    @Test
    public void registrationNegativeEmailTest() {
        var actualErrorMessage = new UserBugRedLoginRegistrationPage(driver)
            .open()
            .sendKeysToNameTextField(FAKER.name().username())
            .sendKeysToEmailTextField(FAKER.name().username())
            .sendKeysToPasswordTextField(FAKER.internet().password())
            .clickToRegisterButtonError()
            .getRegisterErrorMessageText();

        assertThat(actualErrorMessage)
            .as("Registration was successfully completed")
            .isEqualTo("register_not_correct_field (email)");
    }
}
