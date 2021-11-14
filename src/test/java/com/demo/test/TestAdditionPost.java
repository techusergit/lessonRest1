package com.demo.test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;


public class TestAdditionPost {

    @Test()
    public void postUser() {

        RequestSpecification speca = given();
        ValidatableResponse resp = speca
                .baseUri(TestAdditionGet.baseURL)
                .contentType(ContentType.JSON)
                .body(new File("src/test/resources/userDataforPost.JSON"))
                .when().post()
                .then().log().all()
                .assertThat()
                .statusCode(201)
                .body("status", equalTo("Created"))
                .body("userId", notNullValue());
    }

    @Test()
    public void putUserWithPost() {

        given()
                .baseUri(TestAdditionGet.baseURL)
                .basePath("45")
                .contentType(ContentType.JSON)
                .body("{ \"userName\": \"Mike\", \"role\": \"admin\" }")
                .when().post()
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("", hasKey("status"))
                .body("status", equalTo("Updated"));
    }

    @Test()
    public void putUserWithPostDoesntCreateUser() {

        given()
                .baseUri(TestAdditionGet.baseURL)
                .basePath("45")
                .contentType(ContentType.JSON)
                .body("{ \"userName\": \"Mike\", \"role\": \"admin\" }")
                .when().post()
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("status", not("Created"));
    }
}
