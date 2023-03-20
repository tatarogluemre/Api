package get_requests;

import base_url.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get12 extends HerOkuAppBaseUrl {
    /*
    Given
            https://restful-booker.herokuapp.com/booking/535
        When
 		    I send GET Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like:
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
    public void get12() {

        //set the url
        spec.pathParams("first","booking","second",535);

        //set the expected data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo expectedData = new BookingPojo("John","Smith",111,true,bookingDatesPojo,"Breakfast");

        //send the request and get the response
        Response response = given().when().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

         //Do Assertion
                BookingPojo actualData = response.as(BookingPojo.class);
                assertEquals(expectedData.getFirstname(),actualData.getFirstname());
                assertEquals(expectedData.getLastname(),actualData.getLastname());


    }
}
