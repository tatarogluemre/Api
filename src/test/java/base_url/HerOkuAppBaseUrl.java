package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static utilities.AuthenticationHerOkuApp.generateToken;

public class HerOkuAppBaseUrl {

    protected RequestSpecification spec;

    @Before  //Her test methodundan önce çalışması için before annotation koyduk
    public void setUp(){

        spec = new RequestSpecBuilder().addHeader("Cookie","token="+generateToken()).setContentType(ContentType.JSON).setBaseUri("https://restful-booker.herokuapp.com/").build();
    }

}
