package com.demo.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestAdditionPost {

    @Test()
    public void testFirstPost() {

        String apiURL = "http://localhost:9999/api/users";

        RequestSpecification spec = RestAssured.given();
        spec.headers("Content-Type", "application/json");
        spec.baseUri(apiURL);
        spec.body("{\"userName\": \"Jack\",  \"role\": \"admin\"}");
        JsonPath resp = spec
                .post(apiURL)
                .then()
                .assertThat()
                .statusCode(201)
                .and()
                .contentType(ContentType.JSON.toString())
                .extract()
                .body()
                .jsonPath();

        Assert.assertEquals(resp.getString("status"), "Created");
        Assert.assertEquals(resp.getString("userId"), "15");
    }

    @Test()
    public void testSecondPost() {

        String apiURL = "http://localhost:9999/api/users/45";

        RequestSpecification spec = RestAssured.given();
        spec.headers("Content-Type", "application/json");
        spec.baseUri(apiURL);
        spec.body("{\"userName\": \"Mike\",  \"role\": \"admin\"}");
        JsonPath resp = spec
                .post(apiURL)
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON.toString())
                .extract()
                .body()
                .jsonPath();

        Assert.assertEquals(resp.getString("status"), "Updated");
    }
}
