package get_requests;

import base_url.GorestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.GoRestPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get13 extends GorestBaseUrl {
    /*
        Given
            https://gorest.co.in/public/v1/users/247154
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
          {
            "id": 247154,
            "name": "Vimala Varman",
            "email": "vimala_varman@schamberger.name",
            "gender": "female",
            "status": "inactive"
                 }
          }
    */

    @Test
    public void get13() {

        //set the url
        spec.pathParams("first","users","second",2508);

        //set the expected data
        GoRestDataPojo goRestDataPojo = new GoRestDataPojo("Vimala Varman","vimala_varman@schamberger.name","female","inactive");
        GoRestPojo expectedData = new GoRestPojo(null,goRestDataPojo);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        
        //Do Assertion
        GoRestPojo actualData= response.as(GoRestPojo.class);
        System.out.println("actualData = " + actualData);
        
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getData().getName(),actualData.getData().getName());
        assertEquals(expectedData.getData().getEmail(),actualData.getData().getEmail());
        assertEquals(expectedData.getData().getGender(),actualData.getData().getGender());
        assertEquals(expectedData.getData().getStatus(),actualData.getData().getStatus());
        

    }
}
