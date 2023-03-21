package put_requests;

import base_url.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyDataPojo;
import pojos.DummyResponseBodyPojo;
import utilities.ObjectMapperUtil;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put02 extends DummyBaseUrl {

/*
    URL: https://dummy.restapiexample.com/api/v1/update/21
    HTTP Request Method: PUT Request
    Request body: {
        "employee_name": "Ali Can",
                "employee_salary": 111111,
                "employee_age": 23,
                "profile_image": "Perfect image"
    }
    Test Case: Type by using Gherkin Language
    Assert:
    i) Status code is 200

    ii) Response body should be like the following
    {
        "status": "success",
            "data": {
        "employee_name": "Ali Can",
                "employee_salary": 111111,
                "employee_age": 23,
                "profile_image": "Perfect image"
    },
        "message": "Successfully! Record has been updated."
    }
     */


    @Test
    public void put02() {

        //set the url
        spec.pathParams("first","update","second",21);

        //set the expected data
        DummyDataPojo expectedData = new DummyDataPojo("Ali Can",111111,23,"Perfect image");
        System.out.println("expectedData = " + expectedData);
        DummyResponseBodyPojo expectedBody = new DummyResponseBodyPojo("success",expectedData,"Successfully! Record has been updated.");

        //send the request and get the response
        Response response = given().spec(spec).when().body(expectedData).put("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
      DummyResponseBodyPojo actualData = ObjectMapperUtil.convertJsonToJava(response.asString(), DummyResponseBodyPojo.class);
        System.out.println("actualData = " + actualData);
      assertEquals(200,response.statusCode());
      assertEquals(expectedData.getEmployee_age(),actualData.getData().getEmployee_age());
      assertEquals(expectedData.getEmployee_salary(),actualData.getData().getEmployee_salary());
      assertEquals(expectedData.getProfil_image(),actualData.getData().getProfil_image());
      assertEquals(expectedData.getEmployee_name(),actualData.getData().getEmployee_name());
      assertEquals(expectedBody.getStatus(),actualData.getStatus());
      assertEquals(expectedBody.getMessage(),actualData.getMessage());





    }
}
