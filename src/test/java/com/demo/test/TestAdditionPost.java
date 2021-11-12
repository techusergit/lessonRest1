package com.demo.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;




public class TestAdditionPost{



/*

    public static final String HOST = "localhost";
    public static final int Port = 8080;
    private static WireMockServer server = new WireMockServer(Port);


    @BeforeMethod
    public void InitiliazeServer(){
        server.start();
        WireMock.configureFor(HOST,Port);
    }
 */


    @Test()
    public void postUser() {

        RequestSpecification speca = given();
        ValidatableResponse resp = speca
                .baseUri(TestAdditionGet.baseURL)
                .contentType(ContentType.JSON)
                .body(new File("src/test/java/Resources/userDataforPost.JSON"))
                .when().post()
                .then().log().all()
                .assertThat()
                .statusCode(201)
                .body("status", equalTo("Created"))
                .body("userId",notNullValue());
    }

  /*
    @Test
    public void UpdateCustomer(){
        UpdateCustomerRequest request = new UpdateCustomerRequest();
        request.setCurrency("000001");
        request.setId(2);
        request.setBillToAddressId(59);
        request.setMarketSegment("000001");
        request.setShipToAddressId(59);
        request.setContactID("100004");

        UpdateCustomerResponce responce =
                given()
                        .baseUri(BaseURL)
                        .basePath("/IgnitionApi/ContactMaster/api/Customers/edit")
                        .header("Authorization", "Bearer " + Token)
                        .contentType(ContentType.JSON)
                        .body(request)
                        .when().post()
                        .then()
                        .statusCode(200)
                        .log().body()
                        .extract().as(UpdateCustomerResponce.class);

        assertThat(responce).
                isNotNull()
                .extracting(UpdateCustomerResponce::getIsOk)
                .isEqualTo("true");
   */ // тест в котором можно подсмотреть  в будущем как использовать поджо классы

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




/*
    @AfterMethod
    public void closeConnectionServer() {
        if (server.isRunning() && null != server) {
            System.out.println("Shutdown");
            server.shutdown();
        }
    }
 */

        }
