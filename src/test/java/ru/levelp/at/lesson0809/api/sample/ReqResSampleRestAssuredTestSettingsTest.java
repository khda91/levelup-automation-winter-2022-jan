package ru.levelp.at.lesson0809.api.sample;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.matchesRegex;
import static org.hamcrest.Matchers.notNullValue;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReqResSampleRestAssuredTestSettingsTest {

    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    @BeforeMethod
    public void setUp() {
        requestSpecification = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            .setBaseUri("https://reqres.in")
            .setContentType(ContentType.JSON)
            .build();

        responseSpecification = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .build();
    }

    @Test
    public void getSingleUserTest() {

        // Дано
        given()
            .spec(requestSpecification)

            // Действие
            .when()
            .get("/api/users/2")

            // Проверка ожидаемого результата
            .then()
            .spec(responseSpecification)
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
            .spec(requestSpecification)
            .body("{\n"
                + "\"name\": \"" + name + "\",\n"
                + "\"job\": \"" + job + "\"\n"
                + "}")

            .when()
            .post("/api/users")

            .then()
            .spec(responseSpecification)
            .statusCode(HttpStatus.SC_CREATED)
            .body("id", matchesRegex("\\d+"))
            .body("name", equalTo(name))
            .body("job", equalTo(job))
            .body("createdAt", notNullValue());
    }
}
