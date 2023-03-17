package get_requests;

import base_url.GorestBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.GoRestTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get10 extends GorestBaseUrl {

    /*
        Given
            https://gorest.co.in/public/v1/users/127758
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
            /*
 {
    "meta": null,
    "data": {
        "id": 127758,
        "name": "Kannan Ahluwalia",
        "email": "ahluwalia_kannan@treutel-beer.name",
        "gender": "female",
        "status": "inactive"
    }
}*/


    @Test
    public void get10() {

        //set the url
        spec.pathParams("first","users","second",127758);

        //set the expected data
        GoRestTestData obj = new GoRestTestData();
        Map<String ,String> expectedDataData = obj.dataMapMethod("Kannan Ahluwalia","ahluwalia_kannan@treutel-beer.name","female","inactive");
        Map<String,Object> expectedData = obj.expectedDataMethod(null,expectedDataData);
        System.out.println("expectedData = " + expectedData);

        //send the request and get the response
        Response response = given().when().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        Map<String,Object> actualData= response.as(HashMap.class);

        assertEquals(expectedData.get("meta"),actualData.get("meta"));
        assertEquals((Map)(expectedData).get("name"),(Map)(actualData).get("name"));
        assertEquals((Map)(expectedData).get("email"),(Map)(actualData).get("email"));
        assertEquals((Map)(expectedData).get("gender"),(Map)(actualData).get("gender"));
        assertEquals((Map)(expectedData).get("status"),(Map)(actualData).get("status"));

    }
}
