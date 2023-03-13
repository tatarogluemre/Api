package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get_Test_03 {
/*


    Given
    https://jsonplaceholder.typicode.com/todos/23
    When
    User send GET Request to the URL
            Then
    HTTP Status Code should be 200
    And
    Response format should be “application/json”
    And
		    “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
    And
		    “completed” is false
    And
		    “userId” is 2
            */

    @Test
    public void get03() {

        //Set the url
        String url = " https://jsonplaceholder.typicode.com/todos/23";

        //Set the expected data

        // Send the request and get response
        Response response = given().when().get(url);
        response.prettyPrint();

        //Do Assertion
        //1.YOl:
        response.
                then().
                statusCode(200).
                contentType("application/json").
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed",equalTo(false)).
                body("userId",equalTo(2));

        //2.YOl:
        response.
                then().
                statusCode(200).
                contentType("application/json").
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(false),
                         "userId",equalTo(2));  //Bu şekilde tek body içinde yaparsak Soft Assertion yapılır.
        //Soft Assertion ile fail durumunda çalışma durmaz diğer assertion işlemleri devam eder.

    }
}
