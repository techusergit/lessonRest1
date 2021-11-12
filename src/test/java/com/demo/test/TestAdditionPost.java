package com.demo.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestAdditionPost{


    @Test()
    public void postUser() {

        RequestSpecification speca = given();
        ValidatableResponse resp = speca
                .baseUri(TestAdditionGet.baseURL)
                .contentType(ContentType.JSON)
                .body("{ \"userName\": \"Jack\",  \"role\": \"admin\"}")
                .when().post()
                .then()
                .assertThat()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("status", equalTo("Created"));
    }

        @Test()
        public void putUserWithPost() {

                     given()

                    .baseUri(TestAdditionGet.baseURL)
                             .basePath("45")
                    .contentType(ContentType.JSON)

                    .body("{ \"userName\": \"Mike\", \"role\": \"admin\" }")
                    .when().post()
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .body("status", equalTo("Updated"));


        }



        }
