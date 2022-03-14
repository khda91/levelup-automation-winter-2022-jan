package ru.levelp.at.lesson0809.api.sample;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.matchesRegex;
import static org.hamcrest.Matchers.notNullValue;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.Map;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0809.api.model.UserCreateRequest;
import ru.levelp.at.lesson0809.api.model.UserCreateResponse;
import ru.levelp.at.lesson0809.api.model.get.SupportData;
import ru.levelp.at.lesson0809.api.model.get.UserData;
import ru.levelp.at.lesson0809.api.model.get.UserGetResponse;
import ru.levelp.at.lesson0809.api.model.get.UsersGetResponse;

public class ReqResSamplePojoExampleTest {

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
        UserGetResponse actualResponse = given()
            .spec(requestSpecification)

            // Действие
            .when()
            .get("/api/users/2")

            // Проверка ожидаемого результата
            .then()
            .spec(responseSpecification)
            .statusCode(200)
            .extract().body().as(UserGetResponse.class);

        var expectedResponse =
            UserGetResponse.builder()
                           .data(UserData.builder()
                                         .id(2L)
                                         .email("janet.weaver@reqres.in")
                                         .firstName("Janet")
                                         .lastName("Weaver")
                                         .avatar("https://reqres.in/img/faces/2-image.jpg")
                                         .build())
                           .support(SupportData.builder()
                                               .url("https://reqres.in/#support-heading")
                                               .text(
                                                   "To keep ReqRes free, contributions "
                                                       + "towards server costs are appreciated!")
                                               .build())
                           .build();

        assertThat(actualResponse).isEqualTo(expectedResponse);
    }

    @Test
    public void createUserTest() {
        Faker faker = new Faker();

        var name = faker.name().fullName();
        var job = faker.job().field();

        given()
            .spec(requestSpecification)
            .body(UserCreateRequest.builder()
                                   .name(name)
                                   .job(job)
                                   .build())

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

    @DataProvider
    public Object[][] createUserOtherCasesDataProvider() {
        return new Object[][] {
            {UserCreateRequest.builder()
                              .name("name")
                              .job("")
                .build()},
            {UserCreateRequest.builder()
                              .name("")
                              .job("job")
                .build()},
            {UserCreateRequest.builder()
                              .name("name")
                              .job(null)
                .build()},
            {UserCreateRequest.builder()
                              .name(null)
                              .job("job")
                .build()}
        };
    }

    @Test(dataProvider = "createUserOtherCasesDataProvider")
    public void createUserOtherCasesTest(UserCreateRequest userCreateRequest) {
        given()
            .spec(requestSpecification)
            .body(userCreateRequest)

            .when()
            .post("/api/users")

            .then()
            .spec(responseSpecification)
            .statusCode(HttpStatus.SC_CREATED)
            .body("id", matchesRegex("\\d+"));
    }

    @Test
    public void createUserDeserializationResponseTest() {
        Faker faker = new Faker();

        var name = faker.name().fullName();
        var job = faker.job().field();

        UserCreateResponse actualResponse = given()
            .spec(requestSpecification)
            .body(UserCreateRequest.builder()
                                   .name(name)
                                   .job(job)
                                   .build())

            .when()
            .post("/api/users")

            .then()
            .spec(responseSpecification)
            .statusCode(HttpStatus.SC_CREATED)
            .extract().body().as(UserCreateResponse.class);

        UserCreateResponse expectedResponse = UserCreateResponse.builder()
                                                                .name(name)
                                                                .job(job)
                                                                .build();

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(actualResponse)
                  .usingRecursiveComparison()
                  .ignoringExpectedNullFields()
                  .isEqualTo(expectedResponse);
            softly.assertThat(actualResponse.getId())
                  .isNotNull()
                  .isPositive();
            softly.assertThat(actualResponse.getCreatedAt())
                  .isNotNull()
                  .isNotBlank();
        });
    }

    @Test
    public void getUsersQueryParamsTest() {

        // Дано
        UsersGetResponse actualResponse = given()
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
            .extract().body().as(UsersGetResponse.class);

        var expectedResponse = UsersGetResponse
            .builder()
            .page(2)
            .perPage(3)
            .total(12)
            .totalPages(4)
            .data(UserData.builder()
                          .id(4L)
                          .email("eve.holt@reqres.in")
                          .firstName("Eve")
                          .lastName("Holt")
                          .avatar("https://reqres.in/img/faces/4-image.jpg")
                          .build())
            .data(UserData.builder()
                          .id(5L)
                          .email("charles.morris@reqres.in")
                          .firstName("Charles")
                          .lastName("Morris")
                          .avatar("https://reqres.in/img/faces/5-image.jpg")
                          .build())
            .data(UserData.builder()
                          .id(6L)
                          .email("tracey.ramos@reqres.in")
                          .firstName("Tracey")
                          .lastName("Ramos")
                          .avatar("https://reqres.in/img/faces/6-image.jpg")
                          .build())
            .support(SupportData.builder()
                                .url("https://reqres.in/#support-heading")
                                .text(
                                    "To keep ReqRes free, contributions towards server costs are appreciated!")
                                .build())
            .build();

        assertThat(actualResponse).isEqualTo(expectedResponse);
    }
}
