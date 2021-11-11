package com.demo.test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.is;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestAdditionGet {

    @Test()
    public void testGetWithoutParams() {
        RequestSpecification spec = RestAssured.given();
        String expectedResponse = "{\n" +
                "  \"users\": [\n" +
                "    {\n" +
                "      \"userName\": \"Andry\",\n" +
                "      \"userId\": 23\n" +
                "    },\n" +
                "    {\n" +
                "      \"userName\": \"Eduard\",\n" +
                "      \"userId\": 12\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        String apiURL = "http://localhost:9999/api/users";
        String response =
                spec.get(apiURL)
                        .then()
                        .assertThat()
                        .contentType("text/plain")
                        .statusCode(200).extract().asString();

        Assert.assertEquals(response, expectedResponse);
    }


    @Test()
    public void testGetWithParams() {
        RequestSpecification spec = RestAssured.given();
        int expectedId = 23;
        String apiURL = "http://localhost:9999/api/users";
        spec.queryParam("userId", "23");
        spec
                .get(apiURL)
                .then()
                .assertThat()
                .contentType("application/json")
                .statusCode(200)
                .body("userName", is("Andry"))
                .body("userId", is(expectedId));
    }
}
