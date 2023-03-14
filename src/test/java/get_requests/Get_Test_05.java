package get_requests;

import base_url.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Get_Test_05 extends HerOkuAppBaseUrl {

   /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User send a request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Sally" and last name is "Brown"
            (Data içerisinde firstname değeri "Sally", lastname değeri "Brown" olan biri olmalı)
     */

    @Test
    public void get05() {

        //Set the Url
        spec.pathParams("first","booking").
                queryParams("firstname","Sally","lastname","Brown");
        //Send the request and get the response
        Response response = given().when().spec(spec).get("/{first}");
        response.prettyPrint();

        //Do Assertion

       //Status code is 200
        response.
                then().statusCode(200);

        //Among the data there should be someone whose firstname is "Sally" and last name is "Brown"
        //            (Data içerisinde firstname değeri "Sally", lastname değeri "Brown" olan biri olmalı)

        assertTrue(response.asString().contains("bookingid"));




    }
}
