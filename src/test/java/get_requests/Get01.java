package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.get;

public class Get01 {

//        Given
//            https://restful-booker.herokuapp.com/booking/55
//        When
//            User sends a GET Request to the url
//        Then
//            HTTP Status Code should be 200
//        And
//            Content Type should be JSON
//        And
//            Status Line should be HTTP/1.1 200 OK
//


    @Test
    public void get01() {
//        -- Set the URL
        String url = " https://restful-booker.herokuapp.com/booking/55 ";

//        -- Set the expected data

//        -- Send the request and get the reponse
        Response response = get(url);
        response.prettyPrint();
//        -- Do assertion
        response.
                then().             //then metodu beklenen değeri assertion yapar.
                statusCode(200).
                contentType("application/json").
                statusLine("HTTP/1.1 200 OK");
    }
}
