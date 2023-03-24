package post_request;

import base_url.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyDataPojo;
import pojos.DummyResponseBodyPojo;
import utilities.ObjectMapperUtil;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post06 extends DummyBaseUrl {

/*
       URL: https://dummy.restapiexample.com/api/v1/create
       HTTP Request Method: POST Request
       Request body:
                     {
                        "employee_name": "Tom Hanks",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image",
                        "id": 4891
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Tom Hanks",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image",
                            "id": 4891
                        },
                        "message": "Successfully! Record has been added."
                    }

 ---------------------------------------------------
      Given
        URL: https://dummy.restapiexample.com/api/v1/create

      And
       Request body:
                     {
                        "employee_name": "Tom Hanks",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image",
                        "id": 4891
                     }

       When
       HTTP Request Method: POST Request



           Then
                 i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Tom Hanks",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image",
                            "id": 4891
                        },
                        "message": "Successfully! Record has been added."
                    }
     */


    @Test
    public void post06() {
        //set the url
        spec.pathParam("first","create");

        //set the expected data

        DummyDataPojo expectedData = new DummyDataPojo("Tom Hanks",1111,23,"Perfectİmage");
        System.out.println("expectedData = " + expectedData);
        DummyResponseBodyPojo dummyResponseBodyPojoExpected = new DummyResponseBodyPojo("success",expectedData,"Successfully! Record has been added.");

        //send the request and get the response

        Response response = given(spec).body(expectedData).post("/{first}");
        response.prettyPrint();

        //Do Assertion

        DummyResponseBodyPojo actualData = ObjectMapperUtil.convertJsonToJava(response.asString(), DummyResponseBodyPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(dummyResponseBodyPojoExpected.getStatus(),actualData.getStatus());
        assertEquals(expectedData.getEmployee_name(),actualData.getData().getEmployee_name());
        assertEquals(expectedData.getEmployee_salary(),actualData.getData().getEmployee_salary());
        assertEquals(expectedData.getProfil_image(),actualData.getData().getProfil_image());
        assertEquals(expectedData.getEmployee_age(),actualData.getData().getEmployee_age());
        assertEquals(dummyResponseBodyPojoExpected.getMessage(),actualData.getMessage());
    }
}
