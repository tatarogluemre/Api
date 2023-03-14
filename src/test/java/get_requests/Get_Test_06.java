package get_requests;

import base_url.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get_Test_06 extends HerOkuAppBaseUrl {
/*
        Given
            https://restful-booker.herokuapp.com/booking/23
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;
    {
    "firstname": "Josh",
    "lastname": "Allen",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "super bowls"
}

*/

    @Test
    public void get06() {

        //set the url
        spec.pathParams("first","booking","second",23);

        //send the request get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        JsonPath jsonPath = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(jsonPath.getString("firstname"),"Josh","firstname uyuşmadı");
        softAssert.assertEquals(jsonPath.getString("lastname"),"Allen","lastname uyuşmadı");
        softAssert.assertEquals(jsonPath.getString("totalprice"),111,"totalprice uyuşmadı");
        softAssert.assertTrue(jsonPath.getBoolean("depositpaid"),"depositpaid uyuşmadı");
        softAssert.assertEquals(jsonPath.getString("bookingdates.checkin"),"2018-01-01","checkin uyuşmadı");
        softAssert.assertEquals(jsonPath.getString("bookingdates.checkout"),"2019-01-01","checkout uyuşmadı");
        softAssert.assertEquals(jsonPath.getString("additionalneeds"),"midnight snack","additionalneeds uymadı");



        // HTTP Status Code should be 200
        response.
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                //1.Yol:
                body("firstname",equalTo("Josh"),
                        "lastname",equalTo("Allen"),
                "totalprice",equalTo(111),
                        "depositpaid",equalTo(true),
                        "bookingdates.checkin",equalTo("2018-01-01"),
                       "bookingdates.checkout",equalTo("2019-01-01"),
                        "additionalneeds",equalTo("midnight snack"));



            //2.Yol:

        Assert.assertEquals("Josh",jsonPath.getString("firstname"));
        Assert.assertEquals("Allen",jsonPath.getString("lastname"));
        Assert.assertEquals(111,jsonPath.getInt("totalprice"));
        Assert.assertEquals(true,jsonPath.getBoolean("depositpaid"));
        Assert.assertEquals("2018-01-01",jsonPath.getString("bookingdates.checkin"));
        Assert.assertEquals("2019-01-01",jsonPath.getString("bookingdates.checkout"));
        Assert.assertEquals("midnight snack",jsonPath.getString("additionalneeds"));

        //3.Yol:
          //1-  SoftAssert objesi oluştur

    }
}
