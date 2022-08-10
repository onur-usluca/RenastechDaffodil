package code;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GETStatus {

    String url = "https://simple-books-api.glitch.me";

    @Test
    void happyPathTest() {

        Response response = RestAssured.get("https://simple-books-api.glitch.me/status");

        System.out.println("Response: " + response.asString());
    }

    @Test
    (description = "validate status code")
    void ValidateStatusCode(){

        Response response = RestAssured.get(url+ "/status");

        System.out.println(response.asString());

        System.out.println(response.getStatusCode());
    }
}