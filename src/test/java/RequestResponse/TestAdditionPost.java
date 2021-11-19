package RequestResponse;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TestAdditionPost {

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
    public void sendPostCreateNewUser() {
        System.out.println();
        System.out.println("Start Test for send post request for create a new user");
        System.out.println();

        Map<String, String> headers = new HashMap<String, String>() {
            {
                put("Content-Type", ContentType.JSON.toString());
            }
        };

        String responseAfterPostRequestExpected = "{\"status\":\"Created\", \"userId\": 15}";

        String apiURLForPost = String.format(URL, "api/users");

        RequestSpecification spec = RestAssured.given();
        spec.headers(headers);
        spec.baseUri(apiURLForPost);
        spec.body("{ \"userName\": \"Jack\",  \"role\": \"admin\"}");

        String responseAfterPostActual = spec.post(apiURLForPost).then().extract().body().asString();

        Assert.assertEquals(responseAfterPostActual, responseAfterPostRequestExpected);
    }


    @Test
    public void sendPostUpdateUser() {
        System.out.println();
        System.out.println("Start Test for send post request for update exist user");
        System.out.println();

        Map<String, String> headers = new HashMap<String, String>() {
            {
                put("Content-Type", ContentType.JSON.toString());
            }
        };

        String responsePostUpdateExistUserExpected = "{\"status\":\"Updated\"}";

        String apiURLForPost = String.format(URL, "api/users/45");

        RequestSpecification spec = RestAssured.given();
        spec.headers(headers);
        spec.baseUri(apiURLForPost);
        spec.body("{ \"userName\": \"Mike\", \"role\": \"admin\" }");

        String responsePostUpdateExistUserActual = spec.post(apiURLForPost).then().extract().body().asString();

        Assert.assertEquals(responsePostUpdateExistUserActual, responsePostUpdateExistUserExpected);

    }


    // Доделать
    @Test
    public void sendPostUpdateNotExistUser() {
        System.out.println();
        System.out.println("Start Test for send post request for update exist user");
        System.out.println();

        Map<String, String> headers = new HashMap<String, String>() {
            {
                put("Content-Type", ContentType.JSON.toString());
            }
        };

        String responsePostUpdateExistUserExpected = "Request was not matched";

        String apiURLForPost = String.format(URL, "api/users/5000");

        RequestSpecification spec = RestAssured.given();
        spec.headers(headers);
        spec.baseUri(apiURLForPost);
        spec.body("{ \"userName\": \"Mike\", \"role\": \"admin\" }");

        String responsePostUpdateExistUserActual = spec.post(apiURLForPost).then().extract().body().asString();

        System.out.println(responsePostUpdateExistUserActual);

        Assert.assertTrue(responsePostUpdateExistUserActual.contains(responsePostUpdateExistUserExpected));

    }

}
