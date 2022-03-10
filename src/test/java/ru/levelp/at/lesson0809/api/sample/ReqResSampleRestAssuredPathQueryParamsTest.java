package ru.levelp.at.lesson0809.api.sample;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.Map;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReqResSampleRestAssuredPathQueryParamsTest {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    @BeforeSuite
    public void beforeSuite() {
        requestSpecification = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            .setBaseUri("https://reqres.in")
            .setContentType(ContentType.JSON)
            .build();

        responseSpecification = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .build();
    }

    @DataProvider
    public Object[][] pathParamsDataProvider() {
        return new Object[][] {
            {2, "janet.weaver@reqres.in", "Janet", "Weaver"},
            {5, "charles.morris@reqres.in", "Charles", "Morris"},
            {12, "rachel.howell@reqres.in", "Rachel", "Howell"}
        };
    }

    @Test(dataProvider = "pathParamsDataProvider")
    public void getSingleUserPathParamsTest(Integer userId, String email, String firstName, String lastName) {

        // Дано
        given()
            .spec(requestSpecification)
            .pathParam("userId", userId)

            // Действие
            .when()
            .get("/api/users/{userId}")

            // Проверка ожидаемого результата
            .then()
            .spec(responseSpecification)
            .statusCode(200)
            .body("data.id", equalTo(userId))
            .body("data.email", equalTo(email))
            .body("data.first_name", equalTo(firstName))
            .body("data.last_name", equalTo(lastName));
    }

    @Test
    public void getUsersQueryParamsTest() {

        // Дано
        given()
            .spec(requestSpecification)
            .queryParams(Map.of("page", 2,
                "per_page", 3))

            // Действие
            .when()
            .get("/api/users")

            // Проверка ожидаемого результата
            .then()
            .spec(responseSpecification)
            .statusCode(200)
            .body("per_page", equalTo(3))
            .body("page", equalTo(2))
            .body("data", hasSize(3));
    }
}
