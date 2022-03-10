package ru.levelp.at.lesson0809.api.sample;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.matchesRegex;
import static org.hamcrest.Matchers.notNullValue;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ReqResSampleRestAssuredGlobalSettingsTest {

    @BeforeSuite
    public void beforeSuite() {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            .setContentType(ContentType.JSON)
            .build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .build();

        RestAssured.baseURI = "https://reqres.in";
        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;
    }

    @Test
    public void getSingleUserTest() {

        // Дано
        given()

            // Действие
            .when()
            .get("/api/users/2")

            // Проверка ожидаемого результата
            .then()
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
            .body("{\n"
                + "\"name\": \"" + name + "\",\n"
                + "\"job\": \"" + job + "\"\n"
                + "}")

            .when()
            .post("/api/users")

            .then()
            .statusCode(HttpStatus.SC_CREATED)
            .body("id", matchesRegex("\\d+"))
            .body("name", equalTo(name))
            .body("job", equalTo(job))
            .body("createdAt", notNullValue());
    }
}
