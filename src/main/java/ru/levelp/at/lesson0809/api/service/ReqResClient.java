package ru.levelp.at.lesson0809.api.service;

import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import ru.levelp.at.lesson0809.api.model.UserCreateRequest;

public class ReqResClient {

    private static final String BASE_API_PATH = "/api";
    private static final String USERS_ENDPOINT = BASE_API_PATH + "/users";
    private static final String USER_ENDPOINT = USERS_ENDPOINT + "/{userId}";

    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    public ReqResClient() {
        requestSpecification = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            .setBaseUri("https://reqres.in")
            .setContentType(ContentType.JSON)
            .build();

        responseSpecification = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .build();
    }

    public Response getUser(final Long userId) {
        return given()
            .spec(requestSpecification)
            .when()
            .get(USER_ENDPOINT, userId)
            .then()
            .spec(responseSpecification)
            .extract().response();
    }

    public Response createUser(final UserCreateRequest request) {
        return given()
            .spec(requestSpecification)
            .body(request)
            .when()
            .post(USERS_ENDPOINT)
            .then()
            .spec(responseSpecification)
            .extract().response();
    }

    public Response getUsers() {
        return given()
            .spec(requestSpecification)
            .when()
            .get(USERS_ENDPOINT)
            .then()
            .spec(responseSpecification)
            .extract().response();
    }
}
