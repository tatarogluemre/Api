package herokuapp_smoketest;

import base_url.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static herokuapp_smoketest.S01_Post.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.AuthenticationHerOkuApp.generateToken;


public class S03_Delete extends HerOkuAppBaseUrl {

/*
Given

 */

    @Test
    public void delete01() {

        //set the url
        spec.pathParams("first","booking","second",bookingId);

        //set the expected data

        String expectedData = "Created";

        //send the request get the response

        Response response = given().when().spec(spec).delete("/{first}/{second}");//base url'e addHeader ile headera  generate token methodu ile  cookie  token ekleyerek authentication yaptık
        response.prettyPrint();

        //Do Assertiion
        assertEquals(201,response.statusCode());
        assertEquals(expectedData,response.asString());
    }
}
