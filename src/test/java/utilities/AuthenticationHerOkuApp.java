package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthenticationHerOkuApp {

    public static String generateToken(){

        String url ="https://restful-booker.herokuapp.com/auth";

       /*
       {
    "username" : "admin",
    "password" : "password123"
}
        */
        Map<String,String> login = new HashMap<>();
        login.put("username","admin");
        login.put("password","password123");
        Response response = given().contentType(ContentType.JSON).when().body(login).post(url);
        return response.jsonPath().getString("token");



    }


}
