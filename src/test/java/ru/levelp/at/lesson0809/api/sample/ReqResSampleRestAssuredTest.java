package ru.levelp.at.lesson0809.api.sample;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.matchesRegex;
import static org.hamcrest.Matchers.notNullValue;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class ReqResSampleRestAssuredTest {

    @Test
    public void getSingleUserTest() {

        // Действие
        when()
            .get("https://reqres.in/api/users/2")

            // Проверка ожидаемого результата
            .then()
            .statusCode(200)
            .body("data.id", equalTo(2))
            .body("data.email", equalTo("janet.weaver@reqres.in"))
            .body("data.first_name", equalTo("Janet"))
            .body("data.last_name", equalTo("Weaver"));
    }

    @Test
    public void getSingleUserFailedTest() {

        // Действие
        when()
            .get("https://reqres.in/api/users/2")

            // Проверка ожидаемого результата
            .then()
            .statusCode(200)
            .body("data.id", equalTo(3))
            .body("data.email", equalTo("janet.weaver@reqres.in"))
            .body("data.first_name", equalTo("Janet1"))
            .body("data.last_name", equalTo("Weaver"));
    }

    @Test
    public void getSingleUserWithLoggingTest() {

        // Дано (настройки)
        given()
            .log().all()

            // Действие
            .when()
            .get("https://reqres.in/api/users/2")

            // Проверка ожидаемого результата
            .then()
            .log().all()
            .statusCode(200)
            .body("data.id", equalTo(2))
            .body("data.email", equalTo("janet.weaver@reqres.in"))
            .body("data.first_name", equalTo("Janet"))
            .body("data.last_name", equalTo("Weaver"));
    }

    @Test
    public void createUserTest() {
        Faker faker = new Faker();

        var name = faker.name().fullName();
        var job = faker.job().field();

        given()
            .log().all()
            .contentType(ContentType.JSON)
            .body("{\n"
                + "\"name\": \"" + name + "\",\n"
                + "\"job\": \"" + job + "\"\n"
                + "}")

            .when()
            .post("https://reqres.in/api/users")

            .then()
            .log().all()
            .statusCode(HttpStatus.SC_CREATED)
            .body("id", matchesRegex("\\d+"))
            .body("name", equalTo(name))
            .body("job", equalTo(job))
            .body("createdAt", notNullValue());
    }
}
