package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Get_Test_02 {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/1001
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */
    @Test
    public void get02() {

        //1.Adım set the url
        String url = "  https://restful-booker.herokuapp.com/booking/53465436";
        Response response;


        try{

        //2.Adım Set the expected data -->(Post, Put ,Patch)

        //3.Adım : Send the request get the response
        response = given().when().get(url);
        response.prettyPrint();
        //4.Adım: Do Assertion
        response.
                then().
                statusCode(404).
                statusLine("HTTP/1.1 404 Not Found");

        assertEquals("Cowboy",response.header("Server"));
    }catch (Exception e){
            //Response body contains "Not Found"
        assertTrue( e.getMessage().contains("Not Found"));
        //Response body does not contain "TechProEd"
        assertFalse( e.getMessage().contains("Tech ProEd"));

    }

    }
}
