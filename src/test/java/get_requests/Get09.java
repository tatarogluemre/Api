package get_requests;

import base_url.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09 extends HerOkuAppBaseUrl {
    /*
      Given
          https://restful-booker.herokuapp.com/booking/2170
      When
          I send GET Request to the url
      Then
          Response body should be like that;
           {
            "firstname": "John",
            "lastname": "Smith",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2018-01-01",
                "checkout": "2019-01-01"
            },
            "additionalneeds": "Breakfast"
            }
   */

    @Test
    public void get09() {

        //set the url
        spec.pathParams("first","booking","second",5491);

        //set the expected data

        Map<String,String> bookingDates = new HashMap<>();
        bookingDates.put("checkin","2018-01-01");
        bookingDates.put("checkout","2019-01-01");

        Map<String,Object> data = new HashMap<>();
        data.put("firstname","John");
        data.put("lastname","Smith");
        data.put("totalprice",111);
        data.put("depositpaid",true);
        data.put("bookingdates",bookingDates);
        data.put("additionalneeds","Breakfast");

        //sen the request and get the request

        Response response = given().when().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        Map<String,Object> actualData = response.as(HashMap.class);
        System.out.println(actualData);
        assertEquals(data.get("firstname"),actualData.get("firstname"));
        assertEquals(data.get("lastname"),actualData.get("lastname"));
        assertEquals(data.get("totalprice"),actualData.get("totalprice"));
        assertEquals(data.get("depositpaid"),actualData.get("depositpaid"));
        assertEquals(bookingDates.get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
        assertEquals(bookingDates.get("checkout"),((Map)actualData.get("bookingdates")).get("checkout"));
        assertEquals(data.get("additionalneeds"),actualData.get("additionalneeds"));


    }
}
