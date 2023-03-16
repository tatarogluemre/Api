package put_requests;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Put01 extends JsonPlaceHolderBaseUrl {
/*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "userId": 21,
                 "title": "Wash the dishes",
                 "completed": false
               }
        When
	 		I send PUT Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 21,
									    "title": "Wash the dishes",
									    "completed": false
									    "id": 198
									   }
     */

    @Test
    public void put01() {
        //set the url
        spec.pathParams("first","todos","second",198);

        //Set the expected data
      /*  {
            "userId": 21,
                "title": "Wash the dishes",
                "completed": false
        }*/

        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("userId",21);
        expectedData.put("title","Bulaşıkları pakla");
        expectedData.put("completed",false);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().
                spec(spec).
                contentType(ContentType.JSON).
                body(expectedData).
                when().
                put("/{first}/{second}");

        //Do Assertion

        response.then().statusCode(200);

        Map<String,Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));

    }
    @Test
    public void put01_2Yol() {
        //set the url
        spec.pathParams("first","todos","second",198);

        //Set the expected data
      /*  {
            "userId": 21,
                "title": "Wash the dishes",
                "completed": false
        }*/

        JsonPlaceHolderTestData expectedDataMethod = new JsonPlaceHolderTestData();
        Map<String,Object>expectedData=expectedDataMethod.expectedDataMethod(21,"Bulaşıkları Yıkada",false);

        //Send the request and get the response
        Response response = given().
                spec(spec).
                contentType(ContentType.JSON).
                body(expectedData).
                when().
                put("/{first}/{second}");

        //Do Assertion

        response.then().statusCode(200);

        Map<String,Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));

    }
}