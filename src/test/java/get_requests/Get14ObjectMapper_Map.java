package get_requests;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;
import utilities.ObjectMapperUtil;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get14ObjectMapper_Map extends JsonPlaceHolderBaseUrl {
/*
        Given
	        https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send GET Request to the URL
	 	Then
	 		Status code is 200
	 		And response body is like {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }
     */

    @Test
    public void get14() {

        //Set the url
          spec.pathParams("first","todos","second",198);


          //set the expected data

//       String json ="{\n" +
//               "\t\t\t\t\t\t\t\t\t    \"userId\": 10,\n" +
//               "\t\t\t\t\t\t\t\t\t    \"id\": 198,\n" +
//               "\t\t\t\t\t\t\t\t\t    \"title\": \"quis eius est sint explicabo\",\n" +
//               "\t\t\t\t\t\t\t\t\t    \"completed\": true\n" +
//               "\t\t\t\t\t\t\t\t\t  }";
       String json = JsonPlaceHolderTestData.expectedDataInString(198,"quis eius est sint explicabo",true);

        Map<String , Object> expectedData = ObjectMapperUtil.convertJsonToJava(json, HashMap.class);
        System.out.println("expectedData = " + expectedData);


          //Send the request get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        Map<String , Object> actualData = ObjectMapperUtil.convertJsonToJava(response.asString(), HashMap.class);
        System.out.println("actualData = " + actualData);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("userId"),actualData.get("id"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));




    }
}
