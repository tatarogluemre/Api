package delete_requests;

import base_url.DummyBaseUrl;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import pojos.DummyDeletePojo;
import utilities.ObjectMapperUtil;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Delete02 extends DummyBaseUrl {
   /*
URL: https://dummy.restapiexample.com/api/v1/delete/2
HTTP Request Method: DELETE Request
Test Case: Type by using Gherkin Language
Assert:     i) Status code is 200
            ii) "status" is "success"
            iii) "data" is "2"
            iv) "message" is "Successfully! Record has been deleted"

    Given
 https://dummy.restapiexample.com/api/v1/delete/2
   When
   I send DELETE Request to the Url
   Then
             i) Status code is 200
            ii) "status" is "success"
            iii) "data" is "2"
            iv) "message" is "Successfully! Record has been deleted"


  */

    @Test
    public void delete02() {

        //set the url
        spec.pathParams("first","delete","second",2);

        //set the expected data
        DummyDeletePojo expectedData = new DummyDeletePojo("succes","2","Successfully! Record has been deleted");
        System.out.println("expectedData = " + expectedData);

        //send the request and get the response
        Response response = given(spec).when().delete("/{firs}/{second}");
        response.prettyPrint();

        //DoAssertion
        DummyDeletePojo actualData = ObjectMapperUtil.convertJsonToJava(response.asString(), DummyDeletePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getData(),actualData.getData());
        assertEquals(expectedData.getMessage(),actualData.getMessage());
        assertEquals(expectedData.getStatus(),actualData.getStatus());

    }
}
