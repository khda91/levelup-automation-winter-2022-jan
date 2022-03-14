package ru.levelp.at.lesson0809.api.sample;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0809.api.model.UserCreateRequest;
import ru.levelp.at.lesson0809.api.model.UserCreateResponse;
import ru.levelp.at.lesson0809.api.model.get.SupportData;
import ru.levelp.at.lesson0809.api.model.get.UserData;
import ru.levelp.at.lesson0809.api.model.get.UserGetResponse;
import ru.levelp.at.lesson0809.api.service.ReqResClient;

public class ReqResSampleClientTest {

    private ReqResClient reqResClient;

    @BeforeMethod
    public void setUp() {
        reqResClient = new ReqResClient();
    }

    @Test
    public void getSingleUserTest() {
        UserGetResponse actualResponse = reqResClient.getUser(2L)
                                                     .then()
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
                                                   "To keep ReqRes free, contributions towards "
                                                       + "server costs are appreciated!")
                                               .build())
                           .build();

        assertThat(actualResponse).isEqualTo(expectedResponse);
    }

    @Test
    public void getNotExistingUserTest() {
        var actualResponse = reqResClient.getUser(29L)
                                         .then()
                                         .statusCode(HttpStatus.SC_NOT_FOUND)
                                         .extract().body().as(Object.class);

        assertThat(actualResponse).isNotNull();
    }

    @Test
    public void createUserDeserializationResponseTest() {
        Faker faker = new Faker();

        var name = faker.name().fullName();
        var job = faker.job().field();

        UserCreateResponse actualResponse = reqResClient
            .createUser(UserCreateRequest.builder()
                                         .name(name)
                                         .job(job)
                                         .build())
            .then()
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
}
