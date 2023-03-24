package delete_requests;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.ObjectMapperUtil;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Delete01 extends JsonPlaceHolderBaseUrl {
    /*
     Given
         https://jsonplaceholder.typicode.com/todos/198
     When
   I send DELETE Request to the Url
Then
   Status code is 200
   And Response body is { }
  */

    @Test
    public void delete01() {

        //set the url
        spec.pathParams("first","todos","second",198);

        //set the expected data

        Map<String,String> expectedData = new HashMap<>();

        //send the request and get the response

        Response response = given(spec).when().delete("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
     Map<String,String> actualData = ObjectMapperUtil.convertJsonToJava(response.asString(), HashMap.class);
        assertEquals(200,response.statusCode());
       //1.YOl
        assertEquals(expectedData,actualData);

        //2.Yol
        assertEquals(0,actualData.size());

        //3.Yol
        assertTrue(actualData.isEmpty());

    }
}
