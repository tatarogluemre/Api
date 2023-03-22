package herokuapp_smoketest;

import base_url.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import utilities.ObjectMapperUtil;

import static herokuapp_smoketest.S01_Post.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.AuthenticationHerOkuApp.generateToken;

public class S02_Put extends HerOkuAppBaseUrl {

    /* Given
        1- https://restful-booker.herokuapp.com/booking/{id}
        2- {
    "firstname": "Ali",
    "lastname": "Can",
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
    public void put01() {

        //set the url
        spec.pathParams("first","booking","second",bookingId);

        //set the expected data
        BookingDatesPojo datesPojo = new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo expectedData = new BookingPojo("Emre","Tataroglu",111,true,datesPojo,"Breakfast");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().
                spec(spec).
                contentType(ContentType.JSON).
                header("Cookie","token="+generateToken()).
                when().
                body(expectedData).
                put("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        assertEquals(200,response.statusCode());
      BookingPojo actualData = ObjectMapperUtil.convertJsonToJava(response.asString(),BookingPojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());

    }



}
