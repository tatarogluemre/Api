package post_request;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01 extends JsonPlaceHolderBaseUrl {
    /*
         Given
           1)  https://jsonplaceholder.typicode.com/todos
           2)  {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
                }
        When
         I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void post01() {


        //set the url

        spec.pathParam("first","todos");

        //Set the expected data

       /*
        {"userId": 55,
                "title": "Tidy your room",
                "completed": false,
                "id": 201   }
        */

        Map<String , Object> expectedData = new HashMap<>();
        expectedData.put("userId",55.0);
        expectedData.put("title","Tidy your room");
        expectedData.put("completed",false);
        expectedData.put("id",201);

        //Send the request and get the response

        Response response = given().spec(spec).
                contentType(ContentType.JSON).//
                when().
                body(expectedData). //post yaparken body methodu ile önceden map ile oluşturduğumuz body eklememiz gerekir
                post("/{first}");//Not: burada post yaprken java dilini Json diline çevirmek için pom.xml e json,gson gibi dependency eklememiz gerekir.

        response.prettyPrint();

        //DO Assertion

        //Status code is 201
        assertEquals(201,response.statusCode());

        Map<String,Object> actualData = response.as(HashMap.class); //response.as()-> DE-Serialization ==> Json dilinden Javaya çeviren method Json to Java
        System.out.println("actual Data : "+actualData);

        //burada assertion yapmak için jsondan gelenleri mape çevirdik.
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("userId"), actualData.get("userId"));


    }

}
