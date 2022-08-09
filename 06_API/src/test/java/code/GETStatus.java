package code;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GETStatus {

    @Test
    void happyPathTest() {

        Response response = RestAssured.get("https://simple-books-api.glitch.me/status");

        System.out.println("Response: " + response.asString());


    }
}