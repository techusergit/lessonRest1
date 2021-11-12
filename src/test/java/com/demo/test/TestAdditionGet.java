package com.demo.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
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
                .then()
                .statusCode(200)
               .contentType(ContentType.TEXT)
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
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                 .body("userId", equalTo(23))
                 .body("userName", equalTo("Andry"));

                //.body("users", not(emptyArray()));
    }





}



