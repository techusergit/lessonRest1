package RequestResponse;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestAdditionGet {

    private static final String HOST = "localhost";

    private static final int PORT = 8082;

    private static final String URL = String.format("http://%s:%d/%s", HOST, PORT, "%s");

    private static final WireMockServer WIRE_MOCK_SERVER = new WireMockServer(PORT);

    @BeforeMethod
    public void setUpWireMockServer() {
        WIRE_MOCK_SERVER.start();
        WireMock.configureFor(HOST, PORT);
    }

    @AfterMethod(alwaysRun = true)
    public void stopWireMockServer() {
        if (WIRE_MOCK_SERVER.isRunning()) {
            System.out.println("Shot Down");
            WIRE_MOCK_SERVER.stop();
        }
    }

    @Test
    public void sendGetRequestGetAllUsers() {

        System.out.println();
        System.out.println("Start Test for get the list of user ");
        System.out.println();

        String responseGetMethodExpected = "{\n  \"users\": [\n    {\n      \"userName\": \"Andry\",\n      \"userId\": 23\n    },\n    {\n      \"userName\": \"Eduard\",\n      \"userId\": 12\n    }\n  ]\n}";

        String apiURL = String.format(URL, "api/users");

        //Get response and check: status code, header and response for all users

        String responseGetMethodActual = RestAssured.given()
                .get(apiURL)
                .then()
                .assertThat()
                .statusCode(200)
                .assertThat()
                .header("Content-Type", ("text/plain"))
                .extract()
                .body()
                .asString();

        // Check the responses after get method and compare the responses
        Assert.assertEquals(responseGetMethodActual, responseGetMethodExpected);

    }

    @Test
    public void sendGetRequestGetUserInfo() {
        System.out.println();
        System.out.println("Start Test for get info for user");
        System.out.println();

        String responseGetWithParamsExpected = "{\n      \"userName\": \"Andry\",\n      \"userId\": 23\n    }";

        String apiURLGetUserInfo = String.format(URL, "api/users?userId=23");

        //Get response and check: status code, header and response for one user
        String responseGetWithParamsActual = RestAssured.given()
                .contentType(ContentType.JSON)
                .get(apiURLGetUserInfo)
                .then()
                .assertThat()
                .statusCode(200)
                .assertThat()
                .header("Content-Type", ("application/json"))
                .extract().response()
                .asString();

        // Check the responses after get method and compare the responses
        Assert.assertEquals(responseGetWithParamsActual, responseGetWithParamsExpected);

    }

    @Test
    public void sendGetRequestUserNotFound() {
        System.out.println();
        System.out.println("Start Test for check that user not found");
        System.out.println();

        String apiURLUserNotExistUser = String.format(URL, "api/users?userId=1000");

//        Get response and check: status code, header and response for one user
        ValidatableResponse responseFromApiUserNotFound = given()
                .get(apiURLUserNotExistUser)
                .then()
                .assertThat()
                .statusCode(404);

        if (responseFromApiUserNotFound.extract().response().getStatusCode() == 404) {
            System.out.println();
            System.out.println("User not found");
        }

    }

    @Test
    public void sendGetForCreateNewUser() {
        System.out.println();
        System.out.println("Start Test for send post request for create a new user");
        System.out.println();

        Map<String, String> headers = new HashMap<String, String>() {
            {
                put("Content-Type", ContentType.JSON.toString());
            }
        };

        String apiURLForPost = String.format(URL, "api/users");

        RequestSpecification spec = RestAssured.given();
        spec.headers(headers);
        spec.baseUri(apiURLForPost);
        spec.body("{ \"userName\": \"Jack\",  \"role\": \"admin\"}");

        ///Send get request for create a user

        String responseAfterPostActual = spec.get(apiURLForPost).then().extract().body().asString();

        int responseStatusCode = spec.get().statusCode();

        Assert.assertEquals(responseStatusCode, 404);

    }

}
