package code;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GETbooks {

    String baseUrl = RestAssured.baseURI = "https://simple-books-api.glitch.me";

    @Test
    (description = "Given a baseUrl When make GET call w /book Then Verify status Code is 200")
    void userRetrieveListOfTheBooks(){

        // Given
        String url = "https://simple-books-api.glitch.me";

        //When
        Response response = RestAssured.get(url+"/books");
        int actualStatusCode= response.getStatusCode();
        int expectedStatusCode = 200;

        // System.out.println(response.getBody().asString());

        // Then
        Assert.assertEquals(actualStatusCode, expectedStatusCode);
    }

    @Test
    (description = "Given a baseUrl When make GET call w /books and use query param limit=2 Then Verify status Code is 200")
    void userRetrieveListOfTheBooksLimit2(){

        // Given
        RequestSpecification requestBody = given().queryParam("limit", 2);

        //When
        Response response = requestBody.when().get("/books");

        // Then
        response.then().assertThat().statusCode(200);

        String bookId = response.jsonPath().getString("[1].name");

        System.out.println(response.getBody().asString());
        System.out.println("BookId: "+bookId);
    }

    @Test
    (description = "Given a baseUrl When make GET call w /books and use query param type=fiction Then Verify status Code is 200")
    void userRetrieveListOfTheBooksTypeFiction(){

        //Given
        RequestSpecification requestBody = given().queryParam("type", "fiction");

        //When
        Response response = requestBody.when().get("/books");

        //Then
        response.then().assertThat().statusCode(200);

        System.out.println(response.getBody().asString());
        String type = response.jsonPath().getString("[0].type");

        System.out.println(type);

    }

    @Test
    (description = "Given a baseUrl When make GET call w /books and use query param type=crime(not exist) Then Verify status Code is 400")
    void userRetrieveListOfTheBooksUnExistType(){

        //Given
        RequestSpecification requestBody = given().queryParam("type", "crime");

        //When
        Response response = requestBody.when().get("/books");

        //Then
        response.then().assertThat().statusCode(400);

    }
}
