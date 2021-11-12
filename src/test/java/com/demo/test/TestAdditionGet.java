package com.demo.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;



public class TestAdditionGet {


    public static String baseURL = "http://localhost:8080/api/users";


    @Test()
    public void getUsersIsNotEmptyt() {
        given()
                .baseUri(baseURL)
               // .basePath("users")
                .when().get()
                .then().log().all()
                .statusCode(200)
                .contentType("text/plain")
              //  .body(  "users", not(emptyArray()))
                .assertThat().body(not(emptyArray()));
              // .body("users",equalTo(5) );
    }

    @Test()
    public void getUsersIsNotEmpty() {
        RequestSpecification speca = RestAssured.given();
        speca.queryParam("userId", "23");
        ValidatableResponse resp = speca
                .baseUri(baseURL)
                // .basePath("users")
                .get()
                .then().log().all()
                .statusCode(200)
                .contentType("application/json")
                .contentType(ContentType.JSON)
                 .body("userId", equalTo(23))
                 .body("userName", equalTo("Andry"));

                //.body("users", not(emptyArray()));
    }

    @Test()
    public void getUsersContent() {
        String expectation = "{\n  \"users\": [\n    {\n      \"userName\": \"Andry\",\n      \"userId\": 23\n    },\n    {\n      \"userName\": \"Eduard\",\n      \"userId\": 12\n    }\n  ]\n}";
        RequestSpecification specforresp = RestAssured.given();
        String responsee =  specforresp
                // .basePath("users")
                .get(baseURL)
                .then().log().all()
                .statusCode(200)
                .contentType("text/plain")
        .extract()
                .asString();

        Assert.assertEquals(responsee,expectation);

    }
}
