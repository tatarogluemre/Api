package get_requests;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get_Test_07 extends JsonPlaceHolderBaseUrl {
    /*
        Given
              https://jsonplaceholder.typicode.com/todos
      When
          I send GET Request to the URL == > URL'e Get Request gonderin
      Then
          1)Status code is 200 == > Status kodu 200 olmali
          2)Print all ids greater than 190 on the console ==> id si 190 dan buyuk olanlari konsola yazdirin
            Assert that there are 10 ids greater than 190 == > 10 tane id nin 190 dan buyuk oldugunu dogrulayin
          3)Print all userIds whose ids are less than 5 on the console ==> id si 5 den kucuk olan tum userid lerini konsolunu yazdirin
            Assert that the number of userIds whose ids are less than 5 is 4 ==> id si 5 den kucuk olan 4 tane userId oldugunu dogrulayin
          4)Print all titles whose ids are less than 5 ==> ıd si 5 den kucuk olan tum basliklari yazdirin
            Assert that "delectus aut autem" is one of the titles whose id is less than 5 ==> id si 5 den kucuk olan datalarin birinin
            basliginin "delectus aut autem" icerdigini dogrulayin
     */

    @Test
    public void get07() {
        //set the url
        spec.pathParam("first","todos");

        //set the expexted data

        //send the request and get the response
        Response response = given().when().spec(spec).get("/{first}");
        //response.prettyPrint();

        //Do Assertion

       assertEquals(200,response.statusCode());

       JsonPath jsonPath = response.jsonPath();
        //id si 190 dan buyuk olanlari konsola yazdirin
       List<Integer>idList=jsonPath.getList("findAll{it.id>190}.id"); // "findAll{it.id>190}.title"--> Groovy Language kullanarak istenilen koşulda Listden elementler alınabilir.
        System.out.println("dataList = " + idList);
        //10 tane id nin 190 dan buyuk oldugunu dogrulayin
        assertEquals(10,idList.size());

        //id si 5 den kucuk olan tum userid lerini konsola yazdirin
        List<Integer> useridList = jsonPath.getList("findAll{it.id<5}.userId");
        System.out.println("useridList = " + useridList);
        //id si 5 den kucuk olan 4 tane userId oldugunu dogrulayin
        assertEquals(4,useridList.size());

        //ıd si 5 den kucuk olan tum basliklari yazdirin
        List<String> titleList = jsonPath.getList("findAll{it.id<5}.title");
        System.out.println("titleList = " + titleList);
        //id si 5 den kucuk olan datalarin birinin basliginin "delectus aut autem" icerdigini dogrulayin
        assertTrue("delectus aut autem içermiyor",titleList.contains("delectus aut autem"));




    }
}
