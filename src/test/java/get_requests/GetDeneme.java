package get_requests;

import base_url.SwaggerBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetDeneme extends SwaggerBaseUrl {

    @Test
    public void getDeneme() {

        spec.pathParams("first","pet","second","11");

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        response.then().statusCode(200).
                body("id",equalTo(11));


    }
}
