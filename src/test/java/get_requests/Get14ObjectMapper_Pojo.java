package get_requests;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import utilities.ObjectMapperUtil;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get14ObjectMapper_Pojo extends JsonPlaceHolderBaseUrl {

/*
    Given
    https://jsonplaceholder.typicode.com/todos/198
    When
    I send GET Request to the URL
            Then
    Status code is 200
    And response body is like {
        "userId": 10,
                "id": 198,
                "title": "quis eius est sint explicabo",
                "completed": true
    }
     */

    @Test
    public void get14Pojo() {

        //set the url
        spec.pathParams("first","todos","second",198);

        //set the expected data
        JsonPlaceHolderPojo expectedData = new JsonPlaceHolderPojo(198,"quis eius est sint explicabo",true);
        System.out.println("expectedData = " + expectedData);

        //send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        JsonPlaceHolderPojo actualData = ObjectMapperUtil.convertJsonToJava(response.asString(),JsonPlaceHolderPojo.class);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getTitle(),actualData.getTitle());
        assertEquals(expectedData.getCompleted(),actualData.getCompleted());
    }
}
