package com.demo.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TestRestTask {

    @Test(suiteName = "Positive")
    public void testGet(){
        RequestSpecification spec = RestAssured.given();

        //String apiURL ="http://localhost:8080/api/mytest?param1=val1";
        String apiURL ="http://localhost:8080/api/users";
        //spec.queryParam("param1", "val1");
        ValidatableResponse resp = spec.get(apiURL).then();
        //resp.extract().body().as(JsonPath.class);
        System.out.println(resp.extract().statusCode());
        System.out.println(resp.extract().contentType());
        System.out.println(resp.extract().body().asString());

    }

    @Test(suiteName = "Positive")
    public void testGetWithParams(){
        RequestSpecification spec = RestAssured.given();

        //String apiURL ="http://localhost:8080/api/mytest?param1=val1";
        String apiURL ="http://localhost:8080/api/users";
        spec.queryParam("userId", 23);
        ValidatableResponse resp = spec.get(apiURL).then();
        //resp.extract().body().as(JsonPath.class);
        System.out.println(resp.extract().statusCode());
        System.out.println(resp.extract().contentType());
        System.out.println(resp.extract().body().asString());

    }

    @Test(suiteName = "Positive")
    public void testPost(){
        Map<String, String> headers = new HashMap<String, String>() {{
            put("Content-Type", ContentType.JSON.toString());
        }};
        String apiURL ="http://localhost:8080/api/users";

        RequestSpecification spec = RestAssured.given();
        spec.headers(headers);
        spec.baseUri(apiURL);
        spec.body("{ \"userName\": \"Jack\",  \"role\": \"admin\"}");
        //spec.queryParams(params);
        ValidatableResponse resp = spec.post(apiURL).then();
        System.out.println(resp.extract().statusCode());
        System.out.println(resp.extract().contentType());
        System.out.println(resp.extract().body().asString());
    }

    @Test(suiteName = "Positive")
    public void testCreate(){
        Map<String, String> headers = new HashMap<String, String>() {{
            put("Content-Type", ContentType.JSON.toString());
        }};
        String apiURL ="http://localhost:8080/api/users/45";

        RequestSpecification spec = RestAssured.given();
        spec.headers(headers);
        spec.baseUri(apiURL);
        spec.body("{ \"userName\": \"Mike\", \"role\": \"admin\" }");
        //spec.queryParams(params);
        ValidatableResponse resp = spec.post(apiURL).then();
        System.out.println(resp.extract().statusCode());
        System.out.println(resp.extract().contentType());
        System.out.println(resp.extract().body().asString());
    }
}
